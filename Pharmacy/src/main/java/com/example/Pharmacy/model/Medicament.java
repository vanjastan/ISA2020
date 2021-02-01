package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medicament")
public class Medicament {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @OneToOne(mappedBy = "medicament", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Pricelist pricelist;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity(){ return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Pricelist getPricelist() { return pricelist; }

    public void setPricelist(Pricelist pricelist) { this.pricelist = pricelist; }
}
