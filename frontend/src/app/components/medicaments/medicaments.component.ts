import { ViewChild } from '@angular/core';
import { Pipe } from '@angular/core';
import { AfterViewInit } from '@angular/core';
import { PipeTransform } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { MedsService } from 'src/app/services/meds.service';
import { Meds } from '../medicamentslist/meds';

@Component({
  selector: 'app-medicaments',
  templateUrl: './medicaments.component.html',
  styleUrls: ['./medicaments.component.css']
})

export class MedicamentsComponent implements OnInit {

  constructor(private medsService: MedsService) { }

  allTypes = [];

  name: "";
  type: "";
  grade = 0;
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
      for (let i=0; i<this.categories.length; i++) {
        if (!this.allTypes.includes(this.categories[i].type, 0)) {
          this.allTypes.push(this.categories[i].type);
        }
      }
      console.log("Meds: ",this.categories)
    }, error => {
      console.log('Error');
    });
  }
}