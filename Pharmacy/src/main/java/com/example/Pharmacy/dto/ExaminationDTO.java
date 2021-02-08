package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Examination;

public class ExaminationDTO {

    private Long id;
    private double price;
    private String duration;
    private String dateOfEx;
    private String rate;
    private String time_exam;
    private UserDTO patient;

    public ExaminationDTO(){

    }

    public ExaminationDTO(Examination examination) {
        id = examination.getId();
        price = examination.getPrice();
        duration = examination.getDuration();
        dateOfEx = examination.getDate();
        rate = examination.getRate();
        time_exam = examination.getTime();
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
        return dateOfEx;
    }

    public void setDate(String dateOfEx) {
        this.dateOfEx = dateOfEx;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time_exam;
    }

    public void setTime(String time_exam) {
        this.time_exam = time_exam;
    }

    public UserDTO getPatient(){
        return patient;
    }

    public void setPatient(UserDTO patient){
        this.patient = patient;
    }
}
