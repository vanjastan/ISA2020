import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { Examinations } from '../../models/examination';
import { HttpClient } from '@angular/common/http';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-schedule-examinations',
  templateUrl: './schedule-examinations.component.html',
  styleUrls: ['./schedule-examinations.component.css']
})
export class ScheduleExaminationsComponent implements OnInit, AfterViewInit {

  ExaminationList: Examinations[];
  ExaminationResults: Examinations[];
  date: string;
  time: string;
  price: number;
  rate: string;
  search: string;
  displayedColumns: string[] = ['date', 'time', 'price', 'rate', 'schedule'];

  dataSource = new MatTableDataSource<Examinations>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: ExaminationsService, private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllExaminations();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllExaminations(){
    this.service.getExaminations().subscribe(data => {
      this.ExaminationList = data;
      this.dataSource.data = data;
      console.log(this.ExaminationList);
    },
    error => {
     console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.ExaminationList;
    }else{
        this.ExaminationResults = this.ExaminationList.filter( result =>
          { 
            return result.price.toString().match(this.search.toLocaleLowerCase()) || 
            result.rate.toLocaleLowerCase().match(this.search.toLocaleLowerCase())     
          } );
            this.dataSource.data = this.ExaminationResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

}
