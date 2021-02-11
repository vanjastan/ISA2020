package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.model.EPrescriptionStatus;
import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EPrescriptionDTO {
    private Long id;
    private String date_of_pub;
    private EPrescriptionStatus status;
    private UserDTO patient;
    private List<Meds> prescriptionMeds = new ArrayList<>();

    public EPrescriptionDTO(){

    }

    public EPrescriptionDTO(EPrescription ePrescription) {
        id = ePrescription.getId();
        date_of_pub = ePrescription.getDate_of_pub();
        status = ePrescription.getStatus();
        patient = new UserDTO(ePrescription.getPatient());
        prescriptionMeds = ePrescription.getMedsByEPrescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_of_pub() {
        return date_of_pub;
    }

    public void setDate_of_pub(String date_of_pub) {
        this.date_of_pub = date_of_pub;
    }

    public EPrescriptionStatus getStatus() {
        return status;
    }

    public void setStatus(EPrescriptionStatus status) {
        this.status = status;
    }

    public UserDTO getPatient() {
        return patient;
    }

    public void setPatient(UserDTO patient) {
        this.patient = patient;
    }

    public List<Meds> getPrescriptionMeds() {
        return prescriptionMeds;
    }

    public void setPrescriptionMeds(List<Meds> prescriptionMeds) {
        this.prescriptionMeds = prescriptionMeds;
    }
}
