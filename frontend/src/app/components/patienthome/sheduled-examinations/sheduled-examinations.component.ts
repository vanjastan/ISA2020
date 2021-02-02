import { Component, OnInit } from '@angular/core';
import { Examinations } from '../../models/examination';
import { ExaminationsPharmaciest } from '../../models/examinationPharm';

@Component({
  selector: 'app-sheduled-examinations',
  templateUrl: './sheduled-examinations.component.html',
  styleUrls: ['./sheduled-examinations.component.css']
})
export class SheduledExaminationsComponent implements OnInit {

  ExaminationList: Examinations[];
  ExaminationListPh: ExaminationsPharmaciest[];
  doctor:string;
  date:string;
  duration:string;
  price: number
  search: string;
  displayedColumns: string[] = ['doctor', 'date', 'duration', 'price'];

  constructor() { }

  ngOnInit(): void {
  }

}
