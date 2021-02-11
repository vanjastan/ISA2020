package com.example.Pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "examinations_p")
public class ExaminationPh {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private double price;

    @Column(name = "duration")
    private String duration;

    @Column(name = "date_examination")
    private String dateExamination;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private User patient;

    public ExaminationPh(){

    }

    public ExaminationPh(Long id, double price, String duration, String dateExamination) {
        this.id = id;
        this.price = price;
        this.duration = duration;
        this.dateExamination = dateExamination;
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

    public void setDate(String dateExamination) {
        this.dateExamination = dateExamination;
    }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }
}
