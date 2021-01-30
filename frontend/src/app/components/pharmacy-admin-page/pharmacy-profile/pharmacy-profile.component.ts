import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-pharmacy-profile',
  templateUrl: './pharmacy-profile.component.html',
  styleUrls: ['./pharmacy-profile.component.css']
})
export class PharmacyProfileComponent implements OnInit {

  pharmacies: Pharmacies = new Pharmacies("", "", "", "", "");

  constructor(private pharmaciesService: PharmaciesService, private router: Router, public dialog: MatDialog,
    public dialogPass: MatDialog) { }

  ngOnInit(): void {
    this.getPharmaciesInfo();
  }

  getPharmaciesInfo(){
    this.pharmaciesService.getUserInfo().subscribe(data => {
      this.pharmacies = data;
    }, error => {
      console.log("Error in getting pharmacies data!")
    });
  }
}
