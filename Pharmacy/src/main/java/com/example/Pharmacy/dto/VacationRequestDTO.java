package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.User;
import com.example.Pharmacy.model.VacationRequest;

public class VacationRequestDTO {

    private Long id;
    private String from_date;
    private String to_date;
    private boolean confirmed;
    private User user;

    public  VacationRequestDTO(){

    }

    public VacationRequestDTO(VacationRequest v){
        id = v.getId();
        from_date = v.getFrom_date();
        to_date = v.getTo_date();
        confirmed = v.isConfirmed();
        user = v.getUser();
    }

    public VacationRequestDTO(Long id, String from_date, String to_date, boolean finished, boolean confirmed){
        this.id = id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.confirmed = confirmed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_date() {
        return from_date;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public String getTo_date() {
        return to_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public boolean getConfirmed() {
        return confirmed;
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
