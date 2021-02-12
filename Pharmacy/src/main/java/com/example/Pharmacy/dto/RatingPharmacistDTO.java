package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.RatingPharmacist;

public class RatingPharmacistDTO {

    private Long id;
    private int rate;
    private UserDTO patient;
    private UserDTO ph;


    public RatingPharmacistDTO(RatingPharmacist r){
        id = r.getId();
        rate = r.getRate();
        patient = new UserDTO(r.getPatient());
        ph = new UserDTO(r.getPharmacist());
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
}
