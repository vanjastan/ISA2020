package com.example.Pharmacy.dto;

import com.example.Pharmacy.model.Complaint;
import com.example.Pharmacy.model.Complaints;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintsRequest {
    private Long complaintId;
    private Long patientId;
    private String text;

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ComplaintsRequest(Complaints comp) {
        this.complaintId = comp.getId();
        this.patientId = comp.getUser().getId();
        this.text = comp.getText();

    }
}
