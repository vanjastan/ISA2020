import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pharmacy-admin-page',
  templateUrl: './pharmacy-admin-page.component.html',
  styleUrls: ['./pharmacy-admin-page.component.css']
})
export class PharmacyAdminPageComponent implements OnInit {

  constructor(private router:  Router) { }

  ngOnInit(): void {
  }

}
