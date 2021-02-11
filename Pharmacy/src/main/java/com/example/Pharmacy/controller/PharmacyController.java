package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.PharmaciesDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.model.*;
import com.example.Pharmacy.repository.PharmacyRepository;
import com.example.Pharmacy.repository.SubscribedRepository;
import com.example.Pharmacy.service.MedsService;
import com.example.Pharmacy.service.PharmacyService;
import com.example.Pharmacy.service.SubscribedService;
import com.example.Pharmacy.service.UserService;
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
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private SubscribedService subscribedService;

    @Autowired
    private SubscribedRepository subscribedRepository;

    @Autowired
    private UserService userService;

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


    @GetMapping(value = "/dermatologist/{pharmacyId}")
    public ResponseEntity<List<UserDTO>> getPharmacyDermatologist(@PathVariable Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOne(pharmacyId);

        Set<User> dermatologist = pharmacies.getDermatologistPh();
        List<UserDTO> userDTO = new ArrayList<>();

        for( User c : dermatologist) {
            userDTO.add(new UserDTO(c));
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/pharmacist/{pharmacyId}")
    public ResponseEntity<List<UserDTO>> getPharmacyPharmacist(@PathVariable Long pharmacyId) {

        Pharmacies pharmacies = pharmacyService.findOnee(pharmacyId);

        Set<User> pharmacist = pharmacies.getPharmacistPh();
        List<UserDTO> userDTO = new ArrayList<>();

        for( User c : pharmacist) {
            userDTO.add(new UserDTO(c));
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping(value="/subscribed/{id}")
    //@PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<PharmaciesDTO>> findPharmacyBySubscribedUser(@PathVariable("id") Long id) {
        User user = userService.findOne(id);
        Subscribed subsPatient = subscribedRepository.findByPatientId(user.getId());
        //Set<Pharmacies> pharmacies = subsPatient.getPharmacies();
        Set<Pharmacies> pharmacies = user.getSubscribedPharmacies();
        List<PharmaciesDTO> pharmaciesDTO = new ArrayList<>();
        for (Pharmacies p : pharmacies) {
            //if(p.getPatient().getId() == subsPatient.getPatient().getId()) {
            if(p.getPatient().getId() == user.getId()) {
                PharmaciesDTO phDTO = new PharmaciesDTO();
                phDTO.setId(p.getId());
                phDTO.setName(p.getName());
                phDTO.setAddress(p.getAddress());
                phDTO.setCity(p.getCity());
                phDTO.setDescription(p.getDescription());
                phDTO.setRate(p.getRate());
                phDTO.setSubscribed(subsPatient);
                phDTO.setPatient(new UserDTO(p.getPatient()));

                pharmaciesDTO.add(phDTO);
            }
        }
        return new ResponseEntity<>(pharmaciesDTO, HttpStatus.OK);
    }

    @GetMapping(value="/medicine/{id}")
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<PharmaciesDTO>> findPharmacyByMedsId(@PathVariable("id") Long id) {
        Meds med = medsService.findOne(id);
        Set<Pharmacies> pharmacies = med.getPharmaciesMed();
        List<PharmaciesDTO> pharmaciesDTO = new ArrayList<>();
        for (Pharmacies p : pharmacies) {
            PharmaciesDTO phDTO = new PharmaciesDTO();
            phDTO.setId(p.getId());
            phDTO.setName(p.getName());
            phDTO.setAddress(p.getAddress());
            phDTO.setCity(p.getCity());
            phDTO.setDescription(p.getDescription());
            phDTO.setRate(p.getRate());
            phDTO.setPatient(new UserDTO(p.getPatient()));

            pharmaciesDTO.add(phDTO);
        }
        return new ResponseEntity<>(pharmaciesDTO, HttpStatus.OK);
    }
}
