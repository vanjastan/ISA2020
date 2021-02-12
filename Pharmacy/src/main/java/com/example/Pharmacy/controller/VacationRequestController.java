package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.VacationRequestDTO;
import com.example.Pharmacy.mappers.VacationRequestMapper;
import com.example.Pharmacy.model.VacationRequest;
import com.example.Pharmacy.service.VacatioonRequestService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.VacationRequestServiceImpl;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/vacation")
public class VacationRequestController {

    @Autowired
    VacatioonRequestService vacatioonRequestService;

    @Autowired
    VacationRequestServiceImpl vacationRequestServiceImpl;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public ResponseEntity<List<VacationRequestDTO>> getAllVacationRequests(){
        List<VacationRequest> vacationRequests = vacatioonRequestService.findAll();

        List<VacationRequestDTO> vacationDTO = new ArrayList<>();
        for(VacationRequest v : vacationRequests){
            vacationDTO.add(new VacationRequestDTO(v));
        }

        return new ResponseEntity<>(vacationDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/request")
    public ResponseEntity<List<VacationRequestDTO>> getRequest(){
        List<VacationRequest> vacation = vacatioonRequestService.findAll();

        List<VacationRequestDTO> list = new ArrayList<>();

        for (VacationRequest v : vacation){
                if(v.isConfirmed() == false) {
                    VacationRequestDTO vr = new VacationRequestDTO();
                    vr.setId(v.getId());
                    vr.setFrom_date(v.getFrom_date());
                    vr.setTo_date(v.getTo_date());
                    vr.setConfirmed(v.isConfirmed());

                    list.add(vr);
                }

        }

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping(value = "/request/{user_id}")
    public ResponseEntity<List<VacationRequestDTO>> getRequests(){
        List<VacationRequest> vacation = vacatioonRequestService.findAll();

        List<VacationRequestDTO> list = new ArrayList<>();

        for (VacationRequest v : vacation){
            if(v.isConfirmed() == false) {
                VacationRequestDTO vr = new VacationRequestDTO();
                vr.setFrom_date(v.getFrom_date());
                vr.setTo_date(v.getTo_date());
                vr.setConfirmed(v.isConfirmed());
                vr.setId(v.getId());

                list.add(vr);
            }

        }

        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping("/holidays/{requestId}")
    @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity<VacationRequestDTO> confirmationVacation(@RequestBody VacationRequestDTO dto, @PathVariable("requestId") Long requestId) throws MessagingException {
        VacationRequest vacationRequest = vacatioonRequestService.findById(requestId);

        vacationRequest.setConfirmed(true);

        vacationRequest = vacatioonRequestService.save(vacationRequest);
        emailServiceImpl.sendVacationConfirmation(vacationRequest);

        return new ResponseEntity<>(VacationRequestMapper.toDTO(vacationRequest), HttpStatus.OK);

    }

    @PostMapping("/noholidays/{requestId}")
    @PreAuthorize("hasRole('ROLE_ADMINPH')")
    public ResponseEntity<VacationRequestDTO> refuseVacation(@RequestBody VacationRequestDTO dto, @PathVariable("requestId") Long requestId) throws MessagingException {
        VacationRequest vacationRequest = vacatioonRequestService.findById(requestId);


        vacationRequest.setConfirmed(true);

        vacationRequest = vacatioonRequestService.save(vacationRequest);
        emailServiceImpl.sendVacationRefuse(vacationRequest, "Too many people are on vacation.");

        return new ResponseEntity<>(VacationRequestMapper.toDTO(vacationRequest), HttpStatus.OK);

    }
}
