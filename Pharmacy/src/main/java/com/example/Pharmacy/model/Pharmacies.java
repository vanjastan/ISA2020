package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "pharmacies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pharmacies {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id")
    private User adminPh;

    @ManyToMany(mappedBy = "pharmaciesD")
    private Set<User> dermatologistPh = new HashSet<User>();

    @ManyToMany(mappedBy = "pharmaciesP")
    private Set<User> pharmacistPh = new HashSet<User>();

    @ManyToMany(mappedBy = "pharmaciesMed")
    private Set<Meds> medsPh = new HashSet<Meds>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dermatologist_id")
    private User dermatologist;

  /*  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "medicine_id")
    private Meds medicine;*/

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Set<Pricelist> priceList = new HashSet<Pricelist>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "subscriber")
    private Subscribed subscribed;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient")
    private User patient;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    //ocene su nam opisne
    @Column(name = "rate")
    private String rate;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "pharmaciesMed")
    private Set<Meds> meds;

    @OneToOne(mappedBy = "pharmacies")
    private MedsReservation reservation;

    public Pharmacies(){

    }

    public Pharmacies(String name, String address, String city, String rate, String description){
        this.name = name;
        this.address = address;
        this.city = city;
        this.rate = rate;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public Set<Meds> getMeds() {
        return meds;
    }

    public void setMeds(Set<Meds> meds) {
        this.meds = meds;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getDermatologistPh() {
        return dermatologistPh;
    }

    public Set<User> getPharmacistPh() { return pharmacistPh; }

    public Set<Meds> getMedsPh() {
        return medsPh;
    }

    public String getAddress(){ return address; }

    public void setAddress(String address){ this.address = address; }

    public String getCity(){ return city; }

    public void setCity(String city){ this.city = city; }

    public String getRate(){ return rate; }

    public void setRate(String rate){ this.rate = rate; }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }

    public Subscribed getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Subscribed subscribed) {
        this.subscribed = subscribed;
    }

   /* public Meds getMedicine() {
        return medicine;
    }

    public void setMedicine(Meds medicine) {
        this.medicine = medicine;
    }


    /*public Pricelist getPricelist() {
        return pricelist;
    }

    public void setPraselist(Pricelist pricelist) {
        this.pricelist = pricelist;
    }*/
}
