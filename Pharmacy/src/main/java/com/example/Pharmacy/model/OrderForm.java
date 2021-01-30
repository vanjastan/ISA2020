package com.example.Pharmacy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_form")
public class OrderForm {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "medicament_name")
    private String medicament_name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "end_date")
    private String end_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicamentName() { return medicament_name; }

    public void setMedicamentName(String medicament_name){
        this.medicament_name = medicament_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEnd_date() { return end_date; }

    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }

}
