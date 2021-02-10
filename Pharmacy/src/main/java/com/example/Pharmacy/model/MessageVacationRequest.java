package com.example.Pharmacy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVacationRequest {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
