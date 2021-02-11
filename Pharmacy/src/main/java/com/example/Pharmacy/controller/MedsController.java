package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.*;

import javax.mail.MessagingException;

import com.example.Pharmacy.repository.MedsRepository;
import com.example.Pharmacy.service.EPrescriptionService;
import com.example.Pharmacy.service.MedsService;
import com.example.Pharmacy.service.PharmacyService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.MedsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(value = "api/meds")
public class MedsController {

    @Autowired
    private MedsServiceImpl medsImpl;

    @Autowired
    private MedsService medsService;

    @Autowired
    private EmailServiceImpl serviceImpl;

    @Autowired
    private MedsRepository medsRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private EPrescriptionService prescriptionService;

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<MedsDTO>> getAllMeds() {

        List<Meds> meds = medsService.findAll();

        List<MedsDTO> medsDTO = new ArrayList<>();
        for (Meds m : meds) {
            medsDTO.add(new MedsDTO(m));
        }

        return new ResponseEntity<>(medsDTO, HttpStatus.OK);
    }
    @PostMapping("/add_meds")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity addMeds(@RequestBody MedsDTO mdto) {
        medsImpl.addMeds(mdto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="/forPatient/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<MedsDTO>> findMedsByPatientId(@PathVariable("id") Long id) {
        User patient = userService.findOne(id);
        Set<Meds> reservedMeds = patient.getReservedMeds();

        List<MedsDTO> medsDTO = new ArrayList<>();
        for (Meds m : reservedMeds) {
            if(m.isReserved() == true) {
                MedsDTO medDTO = new MedsDTO();
                medDTO.setId(m.getId());
                medDTO.setAllergic(m.getAllergic());
                medDTO.setName(m.getName());
                medDTO.setType(m.getType());
                medDTO.setShape(m.getShape());
                medDTO.setIngredients(m.getIngredients());
                medDTO.setPatient(new UserDTO(m.getPatient()));

                medsDTO.add(medDTO);
            }
        }
        return new ResponseEntity<>(medsDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/cancel/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Meds> cancelMed(@PathVariable("id") Long id){
        Meds med = medsService.findById(id);
        med.setPatient(null);
        med = medsService.save(med);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/addAllergy/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Meds> addAllergy(@PathVariable("id") Long id){
        Meds med = medsService.findById(id);
        med.setAllergic(true);
        med = medsService.save(med);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/byPrescription/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<MedsDTO>> getMedsByEPrescription(@PathVariable("id") Long id) {
        EPrescription ePrescription = prescriptionService.findOne(id);
        Set<Meds> medicines = ePrescription.getMedsByEPrescription();
        List<MedsDTO> medsDTO = new ArrayList<>();
        for(Meds m: medicines) {
            MedsDTO mDTO = new MedsDTO();
            mDTO.setId(m.getId());
            mDTO.setName(m.getName());
            mDTO.setAllergic(m.getAllergic());
            mDTO.setIngredients(m.getIngredients());
            mDTO.setShape(m.getShape());
            mDTO.setType(m.getType());
            mDTO.setCode(m.getCode());
            mDTO.setDailydose(m.getDailydose());
            mDTO.setContradictions(m.getContradictions());
        }

        return new ResponseEntity<>(medsDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{pharmacyId}")
    public ResponseEntity<List<MedsDTO>> getMedsByPharmacyId(@PathVariable("pharmacyId") Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOne(pharmacyId);

        Set<Meds> medicament = pharmacies.getMeds();
        List<MedsDTO> medsDTO = new ArrayList<>();

        for( Meds c : medicament) {
            medsDTO.add(new MedsDTO(c));
        }
        return new ResponseEntity<>(medsDTO, HttpStatus.OK);
    }
}
