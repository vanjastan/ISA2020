package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Meds;

import java.util.List;

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
    private int quantity;
    private int points;

    public MedsDTO(Meds meds) {
        this.id = meds.getId();
        this.name = meds.getName();
        this.code = meds.getCode();
        this.type = meds.getType();
        this.contradictions = meds.getContradictions();
        this.ingredients = meds.getIngredients();
        this.dailydose = meds.getDailydose();
        this.replacement = meds.getReplacement();
        this.shape = meds.getShape();
        this.manufacturer = meds.getManufacturer();
        this.issuing = meds.getIssuing();
        this.notes = meds.getNotes();
        this.quantity = meds.getQuantity();
        this.points = meds.getPoints();
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
