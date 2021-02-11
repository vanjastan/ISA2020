package com.example.Pharmacy.model;

import com.example.Pharmacy.dto.MedsDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "pricelist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pricelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "from_date", nullable = false)
    private String from_date;

    @Column(name = "to_date", nullable = false)
    private String to_date;

   /* @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicament_id")
    private Meds medicament;*/

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "pharmacy_id")
    private Pharmacies pharm;

    public Pricelist(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom_date(){return from_date;}

    public void setFrom_date(String from_date){ this.from_date = from_date; }

    public String getTo_date_date(){return to_date;}

    public void setTo_date(String to_date){ this.to_date = to_date; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

/*    public Meds getMedicament() {
        return medicament;
    }

    public void setMedicament(Meds medicament) {
        this.medicament = medicament;
    }
*/
    public Pharmacies getPharm() {
        return pharm;
    }

    public void setPharm(Pharmacies pharm) {
        this.pharm = pharm;
    }
}
