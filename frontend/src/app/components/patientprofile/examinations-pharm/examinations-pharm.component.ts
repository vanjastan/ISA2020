import { Component, OnInit } from '@angular/core';
import { ExaminationsPharmaciest } from '../../models/examinationPharm';
import { ExaminationsService } from 'src/app/services/examinations.service';

@Component({
  selector: 'app-examinations-pharm',
  templateUrl: './examinations-pharm.component.html',
  styleUrls: ['./examinations-pharm.component.css']
})
export class ExaminationsPharmComponent implements OnInit {

  ExaminationPharmList: ExaminationsPharmaciest[];
  date: string;
  duration: string;
  price: number;

  constructor(private service: ExaminationsService) { }

  ngOnInit(): void {
    this.getAllExaminations();
  }

  getAllExaminations(){
    this.service.getExaminationsPharm().subscribe(data => {
      console.log(data);
      this.ExaminationPharmList = data;
    },
    error => {
     console.log("ERROR");
    });
  }

}
