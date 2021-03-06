package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Patient;
import com.example.Pharmacy.model.RatingDermatologist;

public class RatingDermatologistDTO {

    private Long id;
    private int rate;
    private UserDTO patient;
    private UserDTO derm;

    public RatingDermatologistDTO(RatingDermatologist r){
        id = r.getId();
        rate = r.getRate();
        patient = new UserDTO(r.getPatient());
        derm = new UserDTO(r.getDermatologist());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public UserDTO getPatient() {
        return patient;
    }

    public void setPatient(UserDTO patient) {
        this.patient = patient;
    }
}
