package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.Pharmacies;
import com.example.Pharmacy.model.Pricelist;
import com.example.Pharmacy.service.impl.MedicamentServiceImpl;

public class PricelistDTO {

    private Long id;
    private int price;
    private String from_date;
    private String to_date;
    private PharmaciesDTO pharm;

    public PricelistDTO(){

    }

    public PricelistDTO(Long id, int price, String from_date, String to_date, PharmaciesDTO pharm){
        this.id = id;
        this.price = price;
        this.from_date = from_date;
        this.to_date = to_date;
        this.pharm = pharm;
    }

    public PricelistDTO(Pricelist p){
        id = p.getId();
        price = p.getPrice();
        from_date = p.getFrom_date();
        to_date = p.getTo_date_date();
    }

    public Long getId(){
        return id;
    }

    public int getPrice(){
        return price;
    }

    public String getFrom_date(){
        return from_date;
    }

    public String getTo_date(){
        return to_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFrom_date(String from_date) {
        this.from_date = from_date;
    }

    public void setTo_date(String to_date) {
        this.to_date = to_date;
    }

    public PharmaciesDTO getPharm() {
        return pharm;
    }

    public void setPharm(PharmaciesDTO pharm) {
        this.pharm = pharm;
    }
}
