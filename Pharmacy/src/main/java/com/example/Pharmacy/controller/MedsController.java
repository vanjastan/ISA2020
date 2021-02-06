package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;
import javax.mail.MessagingException;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.MedsRepository;
import com.example.Pharmacy.service.MedsService;
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
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity addMeds(@RequestBody MedsDTO mdto) {
        medsImpl.addMeds(mdto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="/forPatient/{id}")
   // @PreAuthorize("hasRole('ROLE_PATIENT')")
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

    @RequestMapping(value="/reserveMed/{id}", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Meds> reserveMedicine(@PathVariable("id") Long id) throws MessagingException {
        Meds med = medsService.findById(id);
        med.setReserved(true);
        med.setPatient(med.getPatient());
        med = medsService.save(med);
        serviceImpl.sendMessageForReservedMed("patientU45@gmail.com", "", med);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/addAllergy/{id}", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<Meds> addAllergy(@PathVariable("id") Long id){
        Meds med = medsService.findById(id);
        med.setAllergic(true);
        med = medsService.save(med);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
