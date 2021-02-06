import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ComplaintService } from 'src/app/services/complaint.service';
import { Complaints } from '../models/complaints';


@Component({
  selector: 'app-adminhome',
  templateUrl: './complaintslist.component.html',
  styleUrls: ['./complaintslist.component.css']
})
export class ComplaintsListComponent implements OnInit {

  categories = [];
  clickedPatientId = -1;
  clickedComplaintId = -1;
  answer = "";

  constructor(private compService: ComplaintService) { }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll(): void {
    this.compService.getAllComplaints().subscribe(data => {
      this.categories = data;
      console.log("Complaints: ",this.categories)
    }, error => {
      console.log('Error');
    });
  }

  setComplaint(complaint) {
    this.clickedPatientId = complaint.patientId;
    this.clickedComplaintId = complaint.complaintId;
  }

  onSubmit() {

    console.log(this.clickedPatientId);
    console.log(this.answer);

    if (this.clickedPatientId !== -1 && this.answer !== "") {
      let answer: Complaints = new Complaints(this.answer, this.clickedComplaintId, this.clickedPatientId);
      this.compService.sendAnswer(answer).subscribe(data => {
        this.clickedPatientId = -1;
        this.clickedComplaintId = -1;
        this.answer = "";
      });
    }
    
  }


}