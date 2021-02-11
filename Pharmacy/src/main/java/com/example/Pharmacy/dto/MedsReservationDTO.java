package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.MedsReservation;

public class MedsReservationDTO {

    private Long reservationId;
    private String dateReservation;
    private Long numberOfReservation;
    private MedsDTO medicine;
    private PharmaciesDTO pharmacies;

    public MedsReservationDTO(){

    }

    public MedsReservationDTO(MedsReservation medsReservation) {
        this.reservationId = medsReservation.getReservationId();
        this.dateReservation = medsReservation.getDateReservation();
        this.numberOfReservation = medsReservation.getNumberOfReservation();
        this.medicine = new MedsDTO(medsReservation.getMedicine());
        this.pharmacies = new PharmaciesDTO(medsReservation.getPharmacies());
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

    public MedsDTO getMedicine() {
        return medicine;
    }

    public void setMedicine(MedsDTO medicine) {
        this.medicine = medicine;
    }

    public PharmaciesDTO getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(PharmaciesDTO pharmacies) {
        this.pharmacies = pharmacies;
    }
}
