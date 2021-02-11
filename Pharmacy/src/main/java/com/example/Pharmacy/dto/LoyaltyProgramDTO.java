package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.LoyaltyProgram;

public class LoyaltyProgramDTO {

    private Long id;
    private int medicine_points;
    private int examination_points;
    private int consultation_points;
    private String category;

    public LoyaltyProgramDTO(LoyaltyProgram loyaltyProgram) {
        this.id = loyaltyProgram.getId();
        this.medicine_points = loyaltyProgram.getMedicine_points();
        this.examination_points = loyaltyProgram.getExamination_points();
        this.consultation_points = loyaltyProgram.getConsultation_points();
        this.category = loyaltyProgram.getCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMedicine_points() {
        return medicine_points;
    }

    public void setMedicine_points(int medicine_points) {
        this.medicine_points = medicine_points;
    }

    public int getExamination_points() {
        return examination_points;
    }

    public void setExamination_points(int examination_points) {
        this.examination_points = examination_points;
    }

    public int getConsultation_points() {
        return consultation_points;
    }

    public void setConsultation_points(int consultation_points) {
        this.consultation_points = consultation_points;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
