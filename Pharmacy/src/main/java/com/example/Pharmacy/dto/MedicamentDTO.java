package com.example.Pharmacy.dto;

public class MedicamentDTO {

    private String name;
    private int quantity;

    public MedicamentDTO(){
    }

    public MedicamentDTO(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
