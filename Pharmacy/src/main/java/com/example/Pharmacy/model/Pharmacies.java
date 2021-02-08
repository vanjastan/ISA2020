package com.example.Pharmacy.model;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "dermatologist_id")
    private User dermatologist;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "subscriber")
    private Subscribed subscribed;

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

    public String getAddress(){ return address; }

    public void setAddress(String address){ this.address = address; }

    public String getCity(){ return city; }

    public void setCity(String city){ this.city = city; }

    public String getRate(){ return rate; }

    public void setRate(String rate){ this.rate = rate; }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }

}
