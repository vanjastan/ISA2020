package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Meds;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class MedsDTO {

    private Long id;
    private String name;
    private String code;
    private String type;
    private String contradictions;
    private String ingredients;
    private String dailydose;
    private String replacement;
    private String shape;
    private String manufacturer;
    private String issuing;
    private String notes;

    public MedsDTO(Meds meds) {
        id = meds.getId();
        name = meds.getName();
        code = meds.getCode();
        type = meds.getType();
        contradictions = meds.getContradictions();
        ingredients = meds.getIngredients();
        dailydose = meds.getDailydose();
        replacement = meds.getReplacement();
        shape = meds.getShape();
        manufacturer = meds.getManufacturer();
        issuing = meds.getIssuing();
        notes = meds.getNotes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
