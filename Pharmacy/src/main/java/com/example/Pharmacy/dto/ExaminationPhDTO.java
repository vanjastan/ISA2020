package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.ExaminationPh;

public class ExaminationPhDTO {
    private Long id;
    private double price;
    private String duration;
    private String dateExamination;
    private UserDTO patient;

    public ExaminationPhDTO(){

    }

    public ExaminationPhDTO(ExaminationPh examination) {
        id = examination.getId();
        price = examination.getPrice();
        duration = examination.getDuration();
        dateExamination = examination.getDate();
        patient = new UserDTO(examination.getPatient());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getDate() {
        return dateExamination;
    }

    public void setDate(String dateOfEx) {
        this.dateExamination = dateOfEx;
    }

    public UserDTO getPatient(){
        return patient;
    }

    public void setPatient(UserDTO patient){
        this.patient = patient;
    }
}
