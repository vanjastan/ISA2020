package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @Column(name = "reserved")
    private boolean reserved;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private User patient;

    @Column(name = "allergic_reaction")
    private boolean allergic;

    @Column(name = "grade")
    private Double grade;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "medicine", cascade = CascadeType.ALL)
    private MedsReservation reservation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "p_id", referencedColumnName = "prescription_id")
    private EPrescription prescription;

   /* @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicine", cascade = CascadeType.ALL)
    private Set<Pharmacies> pharmacies = new HashSet<Pharmacies>();
*/

    @ManyToMany
    @JoinTable(name = "pharmacy_meds",
            joinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
    private Set<Pharmacies> pharmaciesMed = new HashSet<Pharmacies>();

    @OneToOne(mappedBy = "medicament", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Pricelist pricelist;

    public Meds(Long id, String name, String code, String type, String contradictions, String ingredients, String dailydose, String replacement, String shape, String manufacturer, String issuing, String notes, boolean reserved, boolean allergic) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.type = type;
        this.contradictions = contradictions;
        this.ingredients = ingredients;
        this.dailydose = dailydose;
        this.replacement = replacement;
        this.shape = shape;
        this.manufacturer = manufacturer;
        this.issuing = issuing;
        this.notes = notes;
        this.reserved = reserved;
        this.allergic = allergic;
	}

    public Meds() {

    }

    public Set<Pharmacies> getPharmaciesMed() {
        return pharmaciesMed;
    }

    public void setPharmaciesMed(Set<Pharmacies> pharmaciesMed) {
        this.pharmaciesMed = pharmaciesMed;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public MedsReservation getReservation() {
        return reservation;
    }

    public void setReservation(MedsReservation reservation) {
        this.reservation = reservation;
    }

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

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
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


   /* public Set<Pharmacies> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Set<Pharmacies> pharmacies) {
        this.pharmacies = pharmacies;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EPrescription getPrescription(){
        return prescription;
    }

    public void setPrescription(EPrescription prescription){
        this.prescription = prescription;
    }

    public User getPatient(){
        return patient;
    }

    public void setPatient(User patient){
        this.patient = patient;
    }

    public boolean getAllergic(){
        return allergic;
    }

    public void setAllergic(boolean allergic){
        this.allergic = allergic;
    }
}
