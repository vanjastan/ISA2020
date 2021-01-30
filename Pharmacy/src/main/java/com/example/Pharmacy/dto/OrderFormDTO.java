package com.example.Pharmacy.dto;

public class OrderFormDTO {

    private String medicament_name;
    private int quantity;
    private String end_date;

    public OrderFormDTO(){

    }

    public OrderFormDTO(String medicament_name, int quantity, String end_date){
        this.medicament_name = medicament_name;
        this.quantity = quantity;
        this.end_date = end_date;
    }

    public String getMedicament_nameName(){
        return medicament_name;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getMedicament_name() { return  end_date;}

    public void setMedicament_name(String medicament_name){
        this.medicament_name = medicament_name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setEnd_date(String end_date) { this.end_date = end_date; }
}
