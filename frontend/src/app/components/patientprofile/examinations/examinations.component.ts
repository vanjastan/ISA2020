import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { Examinations } from '../../models/examination';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-examinations',
  templateUrl: './examinations.component.html',
  styleUrls: ['./examinations.component.css']
})
export class ExaminationsComponent implements OnInit, AfterViewInit {

  ExaminationList: Examinations[];
  date: string;
  duration: string;
  price: number;
  search: string;
  displayedColumns = ['date', 'duration', 'price'];

  dataSource = new MatTableDataSource<Examinations>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: ExaminationsService) { }

  ngOnInit(): void {
    this.getAllExaminations();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllExaminations(){
    this.service.getExaminations().subscribe(data => {
      console.log(data);
      this.ExaminationList = data;
      this.dataSource.data = data;
    },
    error => {
     console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
}
