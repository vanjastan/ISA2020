package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.model.MedsReservation;
import com.example.Pharmacy.model.Pharmacies;

public class MedsReservationDTO {

    private Long reservationId;
    private String dateReservation;
    private Long numberOfReservation;
    private Meds medicine;
    private Pharmacies pharmacies;

    public MedsReservationDTO(){

    }

    public MedsReservationDTO(MedsReservation medsReservation) {
        this.reservationId = medsReservation.getReservationId();
        this.dateReservation = medsReservation.getDateReservation();
        this.numberOfReservation = medsReservation.getNumberOfReservation();
        this.medicine = medsReservation.getMedicine();
        this.pharmacies = medsReservation.getPharmacies();
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Long getNumberOfReservation() {
        return numberOfReservation;
    }

    public void setNumberOfReservation(Long numberOfReservation) {
        this.numberOfReservation = numberOfReservation;
    }

    public Meds getMedicine() {
        return medicine;
    }

    public void setMedicine(Meds medicine) {
        this.medicine = medicine;
    }

    public Pharmacies getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Pharmacies pharmacies) {
        this.pharmacies = pharmacies;
    }
}
