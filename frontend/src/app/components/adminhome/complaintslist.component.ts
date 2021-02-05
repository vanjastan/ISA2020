import { Component, OnInit } from '@angular/core';
import { ComplaintService } from 'src/app/services/complaint.service';


@Component({
  selector: 'app-adminhome',
  templateUrl: './complaintslist.component.html',
  styleUrls: ['./complaintslist.component.css']
})
export class ComplaintsListComponent implements OnInit {

  categories = [];

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
}