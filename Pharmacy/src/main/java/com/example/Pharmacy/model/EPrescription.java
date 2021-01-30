package com.example.Pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "e_prescriptions")
public class EPrescription {

    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_of_pub")
    private String date_of_pub;

    @Enumerated(EnumType.STRING)
    private EPrescriptionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_of_pub() {
        return date_of_pub;
    }

    public void setDate_of_pub(String date_of_pub) {
        this.date_of_pub = date_of_pub;
    }

    public EPrescriptionStatus getStatus(){
        return status;
    }

    public void setStatus(EPrescriptionStatus status){
        this.status = status;
    }

    public User getPatient(){
        return user;
    }

    public void setPatient(User patient){
        this.user = patient;
    }
}
