import { Component, OnInit } from '@angular/core';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-header1',
  templateUrl: './header1.component.html',
  styleUrls: ['./header1.component.css']
})
export class Header1Component implements OnInit {

  pharmacies: Pharmacies = new Pharmacies("", "", "", "", "");

  constructor(private pharmaciesService: PharmaciesService ) { }

  ngOnInit(): void {
    this.getJankovicInfo();
  }

  getJankovicInfo(){
    this.pharmaciesService.getJankovicInfo().subscribe(data => {
      this.pharmacies = data;
    }, error => {
      console.log("Error in getting pharmacies data!")
    });
  }
}
