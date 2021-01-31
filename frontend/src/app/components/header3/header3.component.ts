import { Component, OnInit } from '@angular/core';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-header3',
  templateUrl: './header3.component.html',
  styleUrls: ['./header3.component.css']
})
export class Header3Component implements OnInit {

  pharmacies: Pharmacies = new Pharmacies("", "", "", "", "");

  constructor(private pharmaciesService: PharmaciesService) { }

  ngOnInit(): void {
    this.getBenu2Info();
  }

  getBenu2Info(){
    this.pharmaciesService.getBenu2Info().subscribe(data => {
      this.pharmacies = data;
    }, error => {
      console.log("Error in getting pharmacies data!")
    });
  }
}
