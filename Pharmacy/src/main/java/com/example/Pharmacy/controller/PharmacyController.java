package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.PharmaciesDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PharmacyService pharmacyService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Pharmacies> loadAllPh() {return this.pharmacyRepository.findAll();}

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<PharmaciesDTO> getPharmacy(@PathVariable Long id){

        Pharmacies p = pharmacyService.findOne(id);

        if(p == null){
            return new ResponseEntity<PharmaciesDTO>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PharmaciesDTO>(new PharmaciesDTO(p), HttpStatus.OK);
    }


    @GetMapping(value = "/{pharmacyId}/dermatologist")
    public ResponseEntity<List<UserDTO>> getPharmacyDermatologist(@PathVariable Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOne(pharmacyId);

        Set<User> dermatologist = pharmacies.getDermatologistPh();
        List<UserDTO> userDTO = new ArrayList<>();

        for( User c : dermatologist) {
            userDTO.add(new UserDTO(c));
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{pharmacyId}/pharmacist")
    public ResponseEntity<List<UserDTO>> getPharmacyPharmacist(@PathVariable Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOnee(pharmacyId);

        Set<User> pharmacist = pharmacies.getPharmacistPh();
        List<UserDTO> userDTO = new ArrayList<>();

        for( User c : pharmacist) {
            userDTO.add(new UserDTO(c));
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{pharmacyId}/meds")
    public ResponseEntity<List<MedsDTO>> getPharmacyMeds(@PathVariable Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOneee(pharmacyId);

        Set<Meds> medicament = pharmacies.getMedicamentPh();
        List<MedsDTO> medsDTO = new ArrayList<>();

        for( Meds c : medicament) {
            medsDTO.add(new MedsDTO(c));
        }
        return new ResponseEntity<>(medsDTO, HttpStatus.OK);
    }
}
