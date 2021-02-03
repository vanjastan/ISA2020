package com.example.Pharmacy.dto;

public class SubscribedDTO {

    private Long id;
    private String email;

    public SubscribedDTO(){

    }

    public SubscribedDTO( Long id, String email){
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
