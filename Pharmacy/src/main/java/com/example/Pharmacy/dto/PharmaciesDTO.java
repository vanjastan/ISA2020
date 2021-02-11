package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.Subscribed;
import com.example.Pharmacy.model.User;

import javax.persistence.Column;

public class PharmaciesDTO {

    private Long id;
    private Long admin_id;
    private String name;
    private String address;
    private String city;
    private String rate;
    private String description;
    private MedsDTO medicine;
    private Subscribed subscribed;
    private UserDTO patient;

    public PharmaciesDTO(){

    }

    public PharmaciesDTO(Pharmacies ph){
        id = ph.getId();
        name = ph.getName();
        address = ph.getAddress();
        city = ph.getCity();
        rate = ph.getRate();
        subscribed = ph.getSubscribed();
        description = ph.getDescription();
        patient = new UserDTO(ph.getPatient());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAddress(){ return address; }

    public void setAddress(String address){ this.address = address; }

    public String getCity(){ return city; }

    public void setCity(String city){ this.city = city; }

    public String getRate(){ return rate; }

    public void setRate(String rate){ this.rate = rate; }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }

    public MedsDTO getMedicine(){
        return medicine;
    }

    public void setMedicine(MedsDTO medicine){
        this.medicine = medicine;
    }

    public Subscribed getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Subscribed subscribed) {
        this.subscribed = subscribed;
    }

    public UserDTO getPatient(){
        return patient;
    }

    public void setPatient(UserDTO patient){
        this.patient = patient;
    }
}
