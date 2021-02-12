package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.OrderForm;
import com.example.Pharmacy.model.User;

public class OrderFormDTO {

    private Long id;
    private String medicament_name;
    private int quantity;
    private String end_date;
    private  Long admin_id;
    private String status;


    public OrderFormDTO(){

    }

    public OrderFormDTO(Long id, String medicament_name, int quantity, String end_date, Meds meds_name, User adminid, String status){
        this.id = id;
        this.medicament_name = medicament_name;
        this.quantity = quantity;
        this.end_date = end_date;
    }

    public OrderFormDTO(OrderForm o ){
        id = o.getId();
        quantity = o.getQuantity();
        end_date = o.getEnd_date();
        medicament_name = o.getMedicamentName();
        status = o.getStatus();

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

    public void setMedicament_name(String medicament_name){
        this.medicament_name = medicament_name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setEnd_date(String end_date) { this.end_date = end_date; }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
