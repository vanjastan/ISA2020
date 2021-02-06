import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-pharmacys-profile',
  templateUrl: './pharmacys-profile.component.html',
  styleUrls: ['./pharmacys-profile.component.css']
})
export class PharmacysProfileComponent implements OnInit {


  constructor(private pharmaciesService: PharmaciesService, private router: Router, public dialog: MatDialog,
    public dialogPass: MatDialog) { }

  ngOnInit(): void {
    //this.getPharmaciesInfo();
  }

 /* getPharmaciesInfo(){
    this.pharmaciesService.getBenu2Info().subscribe(data => {
      this.pharmacies = data;
    }, error => {
      console.log("Error in getting pharmacies data!")
    });
  }*/
}
