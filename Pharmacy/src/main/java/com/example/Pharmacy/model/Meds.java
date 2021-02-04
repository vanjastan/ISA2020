package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Table(name = "medicaments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Meds {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "type")
    private String type;

    @Column(name = "contradictions")
    private String contradictions;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "dailydose")
    private String dailydose;

    @Column(name = "replacement")
    private String replacement;

    @Column(name = "shape")
    private String shape;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "issuing")
    private String issuing;

    @Column(name = "notes")
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private User patient;

    //NECE DA DODA U BAZU BACI OKO!!!!!!!!!!!!!
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "eprescription_id")
    private EPrescription prescription;

    @ManyToMany
    @JoinTable(name = "pharmacy_meds",
            joinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
    private Set<Pharmacies> pharmaciesMed = new HashSet<Pharmacies>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContradictions() {
        return contradictions;
    }

    public void setContradictions(String contradictions) {
        this.contradictions = contradictions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDailydose() {
        return dailydose;
    }

    public void setDailydose(String dailydose) {
        this.dailydose = dailydose;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIssuing() {
        return issuing;
    }

    public void setIssuing(String issuing) {
        this.issuing = issuing;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }

    public EPrescription getPrescription(){
        return prescription;
    }

    public void setPrescription(EPrescription prescription){
        this.prescription = prescription;
    }
}
