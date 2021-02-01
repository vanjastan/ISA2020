package com.example.Pharmacy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "complaints")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Complaint {

    @Id
    @Column(name = "complaint_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_of_complaint")
    private String date_of_complaint;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient_id")
    private User patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_of_complaint() {
        return date_of_complaint;
    }

    public void setDate_of_complaint(String date_of_complaint) {
        this.date_of_complaint = date_of_complaint;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
