package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Patient;

public class RatingDermatologistDTO {

    private Long id;
    private int rate;
    private Patient patient;

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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
