package com.example.Pharmacy.controller;

import com.example.Pharmacy.dto.ComplaintsRequest;
import com.example.Pharmacy.model.Complaints;
import com.example.Pharmacy.repository.ComplaintsRepository;
import com.example.Pharmacy.service.ComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/complaintss")
public class ComplaintsController {

    @Autowired
    ComplaintsService _complaintService;

    @Autowired
    ComplaintsRepository complaintsRepository;

    @PutMapping("/answer")
    public boolean answer(@RequestBody ComplaintsRequest request){
        return  _complaintService.answer(request);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<ComplaintsRequest>> getAllComp() {

        List<Complaints> comp = _complaintService.findAll();

        List<ComplaintsRequest> compDTO = new ArrayList<>();
        for (Complaints c : comp) {
            compDTO.add(new ComplaintsRequest(c));
        }

        return new ResponseEntity<>(compDTO, HttpStatus.OK);
    }
}
