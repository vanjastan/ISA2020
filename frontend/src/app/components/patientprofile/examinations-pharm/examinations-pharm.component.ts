import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { ExaminationsPharmaciest } from '../../models/examinationPharm';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';


@Component({
  selector: 'app-examinations-pharm',
  templateUrl: './examinations-pharm.component.html',
  styleUrls: ['./examinations-pharm.component.css']
})
export class ExaminationsPharmComponent implements OnInit, AfterViewInit {

  ExaminationPharmList: ExaminationsPharmaciest[];
  date: string;
  duration: string;
  price: number;
  scheduled: boolean;
  search: string;
  displayedColumns = ['date', 'duration', 'price', 'scheduled'];

  dataSource = new MatTableDataSource<ExaminationsPharmaciest>();
  @ViewChild(MatSort) sort: MatSort

  constructor(private service: ExaminationsService) { }

  ngOnInit(): void {
    this.getAllPhExaminations();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllPhExaminations(){
    this.service.getExaminationsPharm().subscribe(data => {
      console.log(data);
      this.ExaminationPharmList = data;
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
