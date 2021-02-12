package com.example.Pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "loyalty")
public class LoyaltyProgram {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medicine_points")
    private int medicine_points;

    @Column(name = "examination_points")
    private int examination_points;

    @Column(name = "consultation_points")
    private int consultation_points;

    @Column(name = "category")
    private String category;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;

    public LoyaltyProgram(){

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
