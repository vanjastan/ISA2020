import { ViewChild } from '@angular/core';
import { AfterViewInit } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MedsService } from 'src/app/services/meds.service';
import { Meds } from '../medicamentslist/meds';

@Component({
  selector: 'app-medicaments',
  templateUrl: './medicaments.component.html',
  styleUrls: ['./medicaments.component.css']
})
export class MedicamentsComponent implements OnInit {

  constructor(private medsService: MedsService) { }

  categories = [];
  clickedMedicineId = -1;
  shape = "";
  code = "";
  ingredients = "";
  contradictions = "";
  dailydose = "";
  replacement = "";
  manufacturer = "";
  issuing = "";
  notes = "";

  ngOnInit(): void {
    this.getAll();
  }

  setMedicine(medicine) {
    this.clickedMedicineId = medicine.id;
    this.shape = medicine.shape;
    this.code = medicine.code;
    this.ingredients = medicine.ingredients;
    this.contradictions = medicine.contradictions;
    this.dailydose = medicine.dailydose;
    this.replacement =  medicine.replacement;
    this.manufacturer = medicine.manufacturer;
    this.issuing = medicine.issuing;
    this.notes = medicine.notes;
  }

  private getAll(): void {
    this.medsService.getAllMeds().subscribe(data => {
      this.categories = data;
      console.log("Meds: ",this.categories)
    }, error => {
      console.log('Error');
    });
  }
}