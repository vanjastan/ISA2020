package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.PharmaciesDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.service.MedsService;
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

    @Autowired
    private MedsService medsService;

    @GetMapping(value = "")
    public ResponseEntity<List<PharmaciesDTO>> getAllPharmacies() {

        List<Pharmacies> pharmacies = pharmacyService.findAll();

        List<PharmaciesDTO> pharmaciesDTO = new ArrayList<>();
        for (Pharmacies p : pharmacies) {
            pharmaciesDTO.add(new PharmaciesDTO(p));
        }

        return new ResponseEntity<>(pharmaciesDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<PharmaciesDTO> getPharmacy(@PathVariable("id") Long id){

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

   /* @GetMapping(value = "/{pharmacyId}/meds")
    public ResponseEntity<List<MedsDTO>> getPharmacyMeds(@PathVariable Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOneee(pharmacyId);

        Set<Meds> medicament = pharmacies.getMedicamentPh();
        List<MedsDTO> medsDTO = new ArrayList<>();

        for( Meds c : medicament) {
            medsDTO.add(new MedsDTO(c));
        }
        return new ResponseEntity<>(medsDTO, HttpStatus.OK);
    }

   /* @RequestMapping(value="/forDermatologist/{id}", method = RequestMethod.GET)
    public List<Pharmacies> findPhByDermatologistId(@PathVariable("id") Long id) {
        List<Pharmacies> ph = pharmacyService.findByDermtologistId(id);
        return ph;
    }*/

    @GetMapping(value="/medicine/{id}")
    // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<PharmaciesDTO>> findPharmacyByMedsId(@PathVariable("id") Long id) {
        Meds med = medsService.findOne(id);
        Set<Pharmacies> pharmacies = med.getPharmacies();
        List<PharmaciesDTO> pharmaciesDTO = new ArrayList<>();
        for (Pharmacies p : pharmacies) {
            PharmaciesDTO phDTO = new PharmaciesDTO();
            phDTO.setId(p.getId());
            phDTO.setName(p.getName());
            phDTO.setAddress(p.getAddress());
            phDTO.setCity(p.getCity());
            phDTO.setDescription(p.getDescription());
            phDTO.setRate(p.getRate());
            phDTO.setMedicine(new MedsDTO(p.getMedicine()));

            pharmaciesDTO.add(phDTO);
        }
        return new ResponseEntity<>(pharmaciesDTO, HttpStatus.OK);
    }

}
