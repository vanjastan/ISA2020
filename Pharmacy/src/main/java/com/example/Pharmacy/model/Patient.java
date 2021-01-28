package com.example.Pharmacy.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient extends User{

    /*@OneToMany(mappedBy = "patients", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Examination> scheduledExDer; //= new ArrayList<Examination>();

    public Set<Examination> getScheduledExDer() {
        return scheduledExDer;
    }

    public void setScheduledExDer(Set<Examination> scheduledExDer){
        this.scheduledExDer = scheduledExDer;
    }*/
}
