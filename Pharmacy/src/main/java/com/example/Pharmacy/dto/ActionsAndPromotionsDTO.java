package com.example.Pharmacy.dto;

public class ActionsAndPromotionsDTO {

    private Long id;
    private String name;
    private String end_date;

    public ActionsAndPromotionsDTO(){

    }

    public ActionsAndPromotionsDTO(Long id, String name, String end_date){
        this.id = id;
        this.name = name;
        this.end_date = end_date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
