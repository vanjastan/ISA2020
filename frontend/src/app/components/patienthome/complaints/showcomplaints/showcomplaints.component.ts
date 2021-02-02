import { Component, OnInit, ViewChild,  AfterViewInit } from '@angular/core';
import { Complaints } from 'src/app/components/models/complaints';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-showcomplaints',
  templateUrl: './showcomplaints.component.html',
  styleUrls: ['./showcomplaints.component.css']
})
export class ShowcomplaintsComponent implements OnInit, AfterViewInit {

  constructor(private service: ComplaintService) { }

  Complaints: Complaints[];
  date_of_complaint:string;
  content:string;
  displayedColumns: string[] = ['date_of_complaint', 'content'];
  dataSource = new MatTableDataSource<Complaints>();
  @ViewChild(MatSort) sort: MatSort;

  ngOnInit(): void {
    this.showAllComplaints();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  showAllComplaints(){
    this.service.getComplaints().subscribe(data => {
      this.Complaints = data;
      this.dataSource.data = data;
      console.log(this.Complaints);
    },
    error => {
     console.log(error);
    });
  }

}
