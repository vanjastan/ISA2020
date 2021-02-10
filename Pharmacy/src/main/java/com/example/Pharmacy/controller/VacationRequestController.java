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

    @PostMapping("/holidays")
    public ResponseEntity<VacationRequestDTO> confirmationVacation(@RequestBody VacationRequestDTO dto) throws MessagingException {
        VacationRequest vacationRequest = vacatioonRequestService.findById(dto.getId());

        vacationRequest.setConfirmed(true);

        emailServiceImpl.sendVacationConfirmation(vacationRequest);

        vacationRequest = vacatioonRequestService.save(vacationRequest);

        return new ResponseEntity<>(VacationRequestMapper.toDTO(vacationRequest), HttpStatus.OK);

    }

    @PostMapping("/noholidays")
    public ResponseEntity<VacationRequestDTO> refuseVacation(@RequestBody VacationRequestDTO dto) throws MessagingException {
        VacationRequest vacationRequest = vacatioonRequestService.findById(dto.getId());

        vacationRequest.setId(dto.getId());
        vacationRequest.setUser(dto.getUser());
        vacationRequest.setConfirmed(true);

        emailServiceImpl.sendVacationRefuse(vacationRequest, "boom");

        vacationRequest = vacatioonRequestService.save(vacationRequest);

        return new ResponseEntity<>(VacationRequestMapper.toDTO(vacationRequest), HttpStatus.OK);

    }
}
