import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Medicine } from '../../models/medicine';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { MatTableDataSource } from '@angular/material/table';
import { MedsService } from 'src/app/services/meds.service';

@Component({
  selector: 'app-e-meds',
  templateUrl: './e-meds.component.html',
  styleUrls: ['./e-meds.component.css']
})
export class EMedsComponent implements OnInit, AfterViewInit {

  search:string;
  Medicine:Medicine[];
  MedicineResult:Medicine[];
  name:string;
  ingredients:string;
  shape:string;
  type:string;
  displayedColumns: string[] = ['name', 'ingredients', 'shape', 'type'];
  dataSource = new MatTableDataSource<Medicine>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private toastr: ToastrService, private service: MedsService) { }

  ngOnInit(): void {
    this.getMedsWithEPres();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Medicine;
    }else{
        this.MedicineResult = this.Medicine.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.MedicineResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    getMedsWithEPres(){
      this.service.getMedicinesWithEPrescriptions().subscribe(data => {
        this.Medicine = data;
        this.dataSource.data = data;
        console.log(this.Medicine);
      },
      error => {
       console.log(error);
      });
    }
}
