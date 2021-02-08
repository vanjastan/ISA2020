package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.EPrescriptionDTO;
import com.example.Pharmacy.dto.ExaminationDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.EPrescriptionRepository;
import com.example.Pharmacy.service.EPrescriptionService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EPrescriptionServiceImpl;
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
@RequestMapping("/prescriptions")
public class EPrescriptionController {

    @Autowired
    EPrescriptionRepository ePrescriptionRepository;

    @Autowired
    EPrescriptionServiceImpl ePrescriptionServiceImpl;

    @Autowired
    UserService userService;

    @Autowired
    EPrescriptionService ePrescriptionService;

    @GetMapping(value = "")
    public ResponseEntity<List<EPrescriptionDTO>> getAllPrescriptions() {

       List<EPrescription> prescriptions = ePrescriptionService.findAll();

       List<EPrescriptionDTO> prescriptionDTO = new ArrayList<>();
       for (EPrescription e : prescriptions) {
           prescriptionDTO.add(new EPrescriptionDTO(e));
       }

       return new ResponseEntity<>(prescriptionDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<EPrescriptionDTO>> findPrescriptionByPatientId(@PathVariable("id") Long id) {
        User user = userService.findOne(id);
        Set<EPrescription> prescriptions = user.getPrescriptions();
        List<EPrescriptionDTO> prescriptionDTOS = new ArrayList<>();
        for(EPrescription e: prescriptions){
            EPrescriptionDTO ePrescriptionDTO = new EPrescriptionDTO();
            ePrescriptionDTO.setDate_of_pub(e.getDate_of_pub());
            ePrescriptionDTO.setId(e.getId());
            ePrescriptionDTO.setStatus(e.getStatus());
            ePrescriptionDTO.setPatient(new UserDTO((e.getPatient())));

            prescriptionDTOS.add(ePrescriptionDTO);
        }
        return new ResponseEntity<>(prescriptionDTOS, HttpStatus.OK);
    }
}
