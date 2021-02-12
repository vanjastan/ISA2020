package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ExaminationPhDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import com.example.Pharmacy.service.ExaminationPhService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.ExaminationPhServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/examinationsPh")
public class ExaminationPhController {

    @Autowired
    ExaminationPhRepository examinationPhRepository;

    @Autowired
    ExaminationPhService examinationPhService;

    @Autowired
    ExaminationPhServiceImpl phServiceImpl;

    @Autowired
    private UserService userService;

    @Autowired
    EmailServiceImpl serviceImpl;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<List<ExaminationPhDTO>> getAllConsultations() {

        List<ExaminationPh> consultations = examinationPhService.findAll();

        List<ExaminationPhDTO> examinationPhDTO = new ArrayList<>();
        for (ExaminationPh e : consultations) {
            examinationPhDTO.add(new ExaminationPhDTO(e));
        }

        return new ResponseEntity<>(examinationPhDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/forPatient/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ExaminationPhDTO>> findExamByPatientId(@PathVariable("id") Long id) {
        User user = userService.findOne(id);
        Set<ExaminationPh> examinations = user.getExaminationsByPh();
        List<ExaminationPhDTO> examinationsDTO = new ArrayList<>();
        for(ExaminationPh e: examinations){
            ExaminationPhDTO examinationPhDTO = new ExaminationPhDTO();
            examinationPhDTO.setPatient(new UserDTO(e.getPatient()));
            examinationPhDTO.setId(e.getId());
            examinationPhDTO.setDate(e.getDate());
            examinationPhDTO.setDuration(e.getDuration());
            examinationPhDTO.setPrice(e.getPrice());

            examinationsDTO.add(examinationPhDTO);

        }
        return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/scheduled/{patientId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ExaminationPhDTO>> findScheduledForPatient(@PathVariable("patientId") Long patientId) {
        User user = userService.findOne(patientId);
        Set<ExaminationPh> examinations = user.getExaminationsByPh();
        List<ExaminationPhDTO> examinationsDTO = new ArrayList<>();
        for(ExaminationPh e: examinations){
            if(e.getPatient() != null) {
                ExaminationPhDTO examinationPhDTO = new ExaminationPhDTO();
                examinationPhDTO.setPatient(new UserDTO(e.getPatient()));
                examinationPhDTO.setId(e.getId());
                examinationPhDTO.setDate(e.getDate());
                examinationPhDTO.setDuration(e.getDuration());
                examinationPhDTO.setPrice(e.getPrice());

                examinationsDTO.add(examinationPhDTO);
            }
        }
        return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/notScheduled/{patientId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ExaminationPhDTO>> findNotScheduledExaminations(@PathVariable("patientId") Long patientId) {
        User user = userService.findOne(patientId);
        Set<ExaminationPh> examinations = user.getExaminationsByPh();
        List<ExaminationPhDTO> examinationsDTO = new ArrayList<>();
        for(ExaminationPh e: examinations){
            if(e.getPatient() == null) {
                ExaminationPhDTO examinationPhDTO = new ExaminationPhDTO();
                examinationPhDTO.setPatient(new UserDTO(e.getPatient()));
                examinationPhDTO.setId(e.getId());
                examinationPhDTO.setDuration(e.getDuration());
                examinationPhDTO.setPrice(e.getPrice());
                examinationPhDTO.setDate(e.getDate());

                examinationsDTO.add(examinationPhDTO);
            }
        }
        return new ResponseEntity<>(examinationsDTO, HttpStatus.OK);
    }

    @RequestMapping(value="/cancel/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<ExaminationPh> cancelExamination(@PathVariable("id") Long id){
        ExaminationPh patientExamination = examinationPhService.findById(id);
        patientExamination.setPatient(null);
        patientExamination = examinationPhService.save(patientExamination);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/freeConsultations")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ExaminationPhDTO>> getFreeConsultations() {

        List<ExaminationPh> consultations = examinationPhService.findAll();

        List<ExaminationPhDTO> freeConsultations = new ArrayList<>();
        for (ExaminationPh e : consultations) {
            if(e.getPatient() == null) {
                ExaminationPhDTO examinationPhDTO = new ExaminationPhDTO();
                examinationPhDTO.setDate(e.getDate());
                examinationPhDTO.setDuration(e.getDuration());
                examinationPhDTO.setPrice(e.getPrice());
                examinationPhDTO.setId(e.getId());

                freeConsultations.add(examinationPhDTO);
            }
        }

        return new ResponseEntity<>(freeConsultations, HttpStatus.OK);
    }

    @RequestMapping(value="/{patientId}/schedule/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<ExaminationPh> scheduleConsultation(@PathVariable("patientId") Long patientId, @PathVariable("id") Long id) throws MessagingException {

        User user = userService.findById(patientId);
        User pharmacist = userService.findById(id);
        ExaminationPh patientConsultation = new ExaminationPh();
        patientConsultation.setPatient(user);
        patientConsultation.setDate(patientConsultation.getDate());
        patientConsultation.setPrice(patientConsultation.getPrice());
        patientConsultation.setPharmacist(pharmacist);
        patientConsultation = examinationPhService.save(patientConsultation);

        try {
            serviceImpl.sendMessageScheduledConsultation("patientU45@gmail.com", "", patientConsultation);
        } catch (Exception e){
            System.out.print("Message service does not work!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
