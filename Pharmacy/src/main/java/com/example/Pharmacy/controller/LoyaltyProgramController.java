package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.LoyaltyProgramDTO;
import com.example.Pharmacy.model.LoyaltyProgram;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.LoyaltyProgramService;
import com.example.Pharmacy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/loyalty")
public class LoyaltyProgramController {

    @Autowired
    private LoyaltyProgramService loyaltyProgramService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<LoyaltyProgramDTO>> getAllPrograms() {

        List<LoyaltyProgram> programs = loyaltyProgramService.findAll();

        List<LoyaltyProgramDTO> programsDTO = new ArrayList<>();
        for (LoyaltyProgram l : programs) {
            programsDTO.add(new LoyaltyProgramDTO(l));
        }

        return new ResponseEntity<>(programsDTO, HttpStatus.OK);
    }

    @GetMapping(value="/forPatient/{patientId}")
    //@PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<LoyaltyProgramDTO> findProgramByPatient(@PathVariable("patientId") Long patientId) {
        User patient = userService.findOne(patientId);
        LoyaltyProgram programs = patient.getProgram();
        LoyaltyProgramDTO programDTO = new LoyaltyProgramDTO();

        programDTO.setCategory(programs.getCategory());
        programDTO.setMedicine_points(programs.getMedicine_points());
        programDTO.setExamination_points(programs.getExamination_points());
        programDTO.setConsultation_points(programs.getConsultation_points());
        programDTO.setId(programs.getId());

        loyaltyProgramService.save(programs);

        return new ResponseEntity<>(programDTO, HttpStatus.OK);
    }
}
