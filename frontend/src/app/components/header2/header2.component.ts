import { Component, OnInit } from '@angular/core';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-header2',
  templateUrl: './header2.component.html',
  styleUrls: ['./header2.component.css']
})
export class Header2Component implements OnInit {

  pharmacies: Pharmacies = new Pharmacies("", "", "", "", "");

  constructor(private pharmaciesService: PharmaciesService) { }

  ngOnInit(): void {
    this.getBenuInfo();
  }

  getBenuInfo(){
    this.pharmaciesService.getBenuInfo().subscribe(data => {
      this.pharmacies = data;
    }, error => {
      console.log("Error in getting pharmacies data!")
    });
  }

}
