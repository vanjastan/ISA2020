package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.MedsDTO;
import com.example.Pharmacy.dto.MedsReservationDTO;
import com.example.Pharmacy.dto.UserDTO;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.MedsReservation;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.User;
import com.example.Pharmacy.service.MedsReservationService;
import com.example.Pharmacy.service.MedsService;
import com.example.Pharmacy.service.UserService;
import com.example.Pharmacy.service.impl.EmailServiceImpl;
import com.example.Pharmacy.service.impl.MedsReservationServiceImpl;
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
@RequestMapping(value = "reservations")
public class MedsReservationController {

    @Autowired
    private MedsReservationService reservationService;

    @Autowired
    private MedsReservationServiceImpl reservationServiceImpl;

    @Autowired
    private EmailServiceImpl serviceImpl;

    @Autowired
    private UserService userService;

    @Autowired
    private MedsService medsService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<MedsReservationDTO>> getAllReservations(){

        List<MedsReservation> reservations = reservationService.findAll();

        List<MedsReservationDTO> medsReservationDTOS = new ArrayList<>();
        for(MedsReservation mr: reservations){
            medsReservationDTOS.add(new MedsReservationDTO(mr));
        }

        return new ResponseEntity<>(medsReservationDTOS, HttpStatus.OK);
    }

    @RequestMapping(value="/addReservation/{medicineId}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<MedsReservationDTO> addReservation(@RequestBody MedsReservationDTO reservationDTO, @PathVariable("medicineId") Long medicineId) throws MessagingException {
        Meds meds = medsService.findOne(medicineId);
        MedsReservation reservation = new MedsReservation();

        reservation.setDateReservation(reservationDTO.getDateReservation());
        reservation.setNumberOfReservation(reservationDTO.getNumberOfReservation());
        reservation.setMedicine(meds);
        reservation = reservationService.save(reservation);

        if(reservation.getMedicine().getId() == meds.getId()) {
            meds.setReserved(true);
            medsService.save(meds);
        }

        serviceImpl.sendMessageForReservedMed("patientU45@gmail.com", "", reservationDTO);
        return new ResponseEntity<>(new MedsReservationDTO(reservation), HttpStatus.OK);
    }
}
