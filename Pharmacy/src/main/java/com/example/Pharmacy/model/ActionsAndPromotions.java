package com.example.Pharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "actions_and_promotions")
public class ActionsAndPromotions {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String end_date;

    public ActionsAndPromotions(){

    }

    public ActionsAndPromotions( String name, String end_date){
        this.name = name;
        this.end_date= end_date;
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

    public String getEnd_date(){ return  end_date;}

    public void setEnd_date(String end_date) { this.end_date = end_date;}
}
