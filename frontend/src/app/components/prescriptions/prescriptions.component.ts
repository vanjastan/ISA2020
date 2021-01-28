import { Component, OnInit } from '@angular/core';
import { Prescription } from '../models/prescription';

@Component({
  selector: 'app-prescriptions',
  templateUrl: './prescriptions.component.html',
  styleUrls: ['./prescriptions.component.css']
})
export class PrescriptionsComponent implements OnInit {

  PrescriptionList: Prescription[];
  date: string;
  medicine: string;
  state: string;

  constructor() { }

  ngOnInit(): void {
  }

}
