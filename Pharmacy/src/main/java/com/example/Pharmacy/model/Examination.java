package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "examinations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Examination {

    @Id
    @Column(name = "exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private double price;

    @Column(name = "duration")
    private String duration;

    @Column(name = "date_examination")
    private String dateOfEx;

    @Column(name = "rate")
    private String rate;

    @Column(name = "time_exam")
    private String time_exam;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private User patient;

    public Examination(Long id, double price, String duration, String dateOfEx, String rate, String time_exam){
        this.id = id;
        this.price = price;
        this.time_exam = time_exam;
        this.duration = duration;
        this.dateOfEx = dateOfEx;
        this.rate = rate;
    }

    public Examination( double price, String duration, String dateOfEx, String rate, String time_exam){
        this.price = price;
        this.time_exam = time_exam;
        this.duration = duration;
        this.dateOfEx = dateOfEx;
        this.rate = rate;
    }

    public Examination(){

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

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }
}
