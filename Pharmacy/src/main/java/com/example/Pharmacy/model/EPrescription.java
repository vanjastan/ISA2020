package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "prescription")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EPrescription {

    @Id
    @Column(name = "prescription_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_pub")
    private String date_of_pub;

    @Enumerated(EnumType.STRING)
    private EPrescriptionStatus status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private User patient;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "prescription", cascade = CascadeType.ALL)
    private Set<Meds> medsByEPrescription = new HashSet<Meds>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_of_pub() {
        return date_of_pub;
    }

    public void setDate_of_pub(String date_of_pub) {
        this.date_of_pub = date_of_pub;
    }

    public Set<Meds> getMedsByEPrescription() {
        return medsByEPrescription;
    }

    public void setMedsByEPrescription(Set<Meds> medsByEPrescription) {
        this.medsByEPrescription = medsByEPrescription;
    }

    public EPrescriptionStatus getStatus(){
        return status;
    }

    public void setStatus(EPrescriptionStatus status){
        this.status = status;
    }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }

    public EPrescription(Long id, String date_of_pub, EPrescriptionStatus status) {
        this.id = id;
        this.date_of_pub = date_of_pub;
        this.status = status;
    }
}
