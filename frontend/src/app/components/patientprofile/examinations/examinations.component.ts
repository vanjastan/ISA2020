import { Component, OnInit } from '@angular/core';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { Examinations } from '../../models/examination';

@Component({
  selector: 'app-examinations',
  templateUrl: './examinations.component.html',
  styleUrls: ['./examinations.component.css']
})
export class ExaminationsComponent implements OnInit {

  ExaminationList: Examinations[];
  date: string;
  duration: string;
  price: number;

  constructor(private service: ExaminationsService) { }

  ngOnInit(): void {
    this.getAllExaminations();
  }

  getAllExaminations(){
    this.service.getExaminations().subscribe(data => {
      console.log(data);
      this.ExaminationList = data;
    },
    error => {
     console.log("ERROR");
    });
  }

}
