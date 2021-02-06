package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Meds;

public class OrderFormDTO {

    private Long id;
    private String medicament_name;
    private int quantity;
    private String end_date;
    private Meds meds_name;

    public OrderFormDTO(){

    }

    public OrderFormDTO(Long id, String medicament_name, int quantity, String end_date, Meds meds_name){
        this.id = id;
        this.medicament_name = medicament_name;
        this.quantity = quantity;
        this.end_date = end_date;
        this.meds_name = meds_name;
    }

    public Long getId() { return id; }

    public int getQuantity(){
        return quantity;
    }

    public String getMedicament_name() { return  medicament_name;}

    public String getEnd_date() {return end_date;}

    public void setId(Long id) {
        this.id = id;
    }

    public Meds getMeds_name(){return  meds_name;}

    public void setMeds_name(Meds meds_name){ this.meds_name = meds_name;}

    public void setMedicament_name(String medicament_name){
        this.medicament_name = medicament_name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setEnd_date(String end_date) { this.end_date = end_date; }
}
