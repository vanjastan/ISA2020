package com.example.Pharmacy.dto;

public class ComplaintDTO {

    private Long id;
    private String date_of_complaint;
    private String content;

    public ComplaintDTO(){

    }

    public ComplaintDTO(Long id, String date_of_complaint, String content) {
        this.id = id;
        this.date_of_complaint = date_of_complaint;
        this.content = content;
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
}
