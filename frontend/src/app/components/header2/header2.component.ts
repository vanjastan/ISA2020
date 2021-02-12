import { Component, OnInit } from '@angular/core';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacist } from '../models/pharmacist';

@Component({
  selector: 'app-header2',
  templateUrl: './header2.component.html',
  styleUrls: ['./header2.component.css']
})
export class Header2Component implements OnInit {

  id:number;

  pharmacies: Pharmacies = new Pharmacies( "", "", "", "", "");

  pharmacy : Pharmacies;


  constructor(private pharmaciesService: PharmaciesService) { }

  pharmacyList : any = [];
  ngOnInit(): void {
    this.getBenuInfo();
  }

  getBenuInfo(){
    this.pharmaciesService.getPhInfo().subscribe(data => {
      this.pharmacies = data;
      console.log(this.pharmacies);
    }, error => {
      console.log("Error in getting pharmacies data!")
    });
  }

}
