package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "subscribed")
public class Subscribed {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private User patient;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subscribed", cascade = CascadeType.ALL)
    private Set<Pharmacies> pharmacies = new HashSet<Pharmacies>();

    public Subscribed(){

    }

    public Subscribed( String email){
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

    public Set<Pharmacies> getPharmacies(){
        return pharmacies;
    }

    public void setPharmacies(Set<Pharmacies> pharmacies){
        this.pharmacies = pharmacies;
    }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }
}
