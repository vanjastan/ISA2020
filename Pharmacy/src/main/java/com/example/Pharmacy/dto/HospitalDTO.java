package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Hospital;

public class HospitalDTO {

    private Long id;
    private String name;
    private String api;

    public HospitalDTO(Long id, String name, String api) {
        this.id = id;
        this.name = name;
        this.api = api;
    }

    public HospitalDTO() {

    }

    public HospitalDTO(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
        this.api = hospital.getApi();
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

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
