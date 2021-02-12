package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "reservation_med")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MedsReservation {

    @Id
    @Column(name = "reservationid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(name = "date_reservation")
    private String dateReservation;

    @Column(name = "number")
    private Long numberOfReservation;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="medicine_id", referencedColumnName = "id")
    private Meds medicine;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pharmacy_id", referencedColumnName = "id")
    private Pharmacies pharmacies;

    public MedsReservation(){

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

    public Long getNumberOfReservation(){
        return numberOfReservation;
    }

    public void setNumberOfReservation(Long numberOfReservation){
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
