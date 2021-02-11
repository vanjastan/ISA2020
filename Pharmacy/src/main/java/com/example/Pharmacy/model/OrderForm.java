package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orderform")
public class OrderForm {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medicament_name")
    private String medicament_name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "end_date")
    private String end_date;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id")
    private User adminph;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderForm", cascade = CascadeType.ALL)
    private Set<OrderFormOffers> orderFormOffers = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAdminph() {
        return adminph;
    }

    public void setAdminph(User adminph) {
        this.adminph = adminph;
    }

    public Set<OrderFormOffers> getOrderFormOffers() {
        return orderFormOffers;
    }

    public void setOrderFormOffers(Set<OrderFormOffers> orderFormOffers) {
        this.orderFormOffers = orderFormOffers;
    }
}
