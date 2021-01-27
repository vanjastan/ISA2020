import { Component, OnInit } from '@angular/core';
import { data } from 'jquery';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../../models/pharmacies';

@Component({
  selector: 'app-allpharmacies',
  templateUrl: './allpharmacies.component.html',
  styleUrls: ['./allpharmacies.component.css']
})
export class AllpharmaciesComponent implements OnInit {

  Pharmacies: Pharmacies[];
  name:string;
  address:string;
  city:string;
  rate:string;

  constructor(private service: PharmaciesService) { }

  ngOnInit(): void {
    this.getAllPharmacies();
  }

  getAllPharmacies(){
    this.service.getPharmacies().subscribe(data => {
      console.log(data);
      this.Pharmacies = data;
    },
    error => {
     console.log("ERROR");
    });
  }
}
