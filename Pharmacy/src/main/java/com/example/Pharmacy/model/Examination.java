package com.example.Pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "examinations")
public class Examination {

    @Id
    @Column(name = "exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private double price;

    @Column(name = "duration")
    private String duration;

    @Column(name = "dateE")
    private String dateOfEx;

    @Column(name = "rate")
    private String rate;

    @Column(name = "time_exam")
    private String time_exam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
