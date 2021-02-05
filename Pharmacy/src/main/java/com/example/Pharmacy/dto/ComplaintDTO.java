package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.User;

public class ComplaintDTO {

    private Long id;
    private String date_of_complaint;
    private String content;
    private User patient;

    public ComplaintDTO(){

    }

    public ComplaintDTO(Long id, String date_of_complaint, String content, User patient) {
        this.id = id;
        this.date_of_complaint = date_of_complaint;
        this.content = content;
        this.patient = patient;
    }

    public String getDate_of_complaint() {
        return date_of_complaint;
    }

    public void setDate_of_complaint(String date_of_complaint) {
        this.date_of_complaint = date_of_complaint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }

    public ComplaintDTO(Complaint comp) {
        this.id = comp.getId();
        this.date_of_complaint = comp.getDate_of_complaint();
        this.content = comp.getContent();
        this.patient = comp.getPatient();
    }
}
