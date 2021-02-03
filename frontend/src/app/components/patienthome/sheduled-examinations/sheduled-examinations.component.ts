import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { Examinations } from '../../models/examination';
import { ExaminationsPharmaciest } from '../../models/examinationPharm';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-sheduled-examinations',
  templateUrl: './sheduled-examinations.component.html',
  styleUrls: ['./sheduled-examinations.component.css']
})
export class SheduledExaminationsComponent implements OnInit {

  ExaminationList: Examinations[];
  ExaminationListResult: Examinations[];
  ExaminationListPh: ExaminationsPharmaciest[];
  ExaminationListPhResult: ExaminationsPharmaciest[];
  date:string;
  duration:string;
  price: number;
  datePh:string;
  durationPh:string;
  pricePh: number;
  search: string;
  displayedColumns: string[] = ['date', 'duration', 'price'];

  displayedColumnsPh: string[] = ['datePh', 'durationPh', 'pricePh'];

  dataSource = new MatTableDataSource<Examinations>();
  @ViewChild(MatSort) sort: MatSort;

  dataSourcePh = new MatTableDataSource<ExaminationsPharmaciest>();
  @ViewChild(MatSort) sortPh: MatSort;

  constructor(private service: ExaminationsService) { }

  ngOnInit(): void {
    this.getScheduledExaminations();
    this.getScheduledConsulations();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
    this.dataSourcePh.sort = this.sort;
  }

  getScheduledExaminations(){
    this.service.getScheduledEx().subscribe(data => {
      this.ExaminationList = data;
      this.dataSource.data = data;
      console.log(this.ExaminationList);
    },
    error => {
     console.log(error);
    });
  }

  getScheduledConsulations(){
    this.service.getScheduledCons().subscribe(data => {
      this.ExaminationListPh = data;
      this.dataSourcePh.data = data;
      console.log(this.ExaminationListPh);
    },
    error => {
     console.log(error);
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.ExaminationList;
    }else{
        this.ExaminationListResult = this.ExaminationList.filter( result =>
          { 
            return result.date.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.ExaminationListResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    public doFilterPh = (value:string)=>{
      if(this.search == ""){
          this.dataSourcePh.data = this.ExaminationListPh;
      }else{
          this.ExaminationListPhResult = this.ExaminationListPh.filter( result =>
            { 
              return result.datePh.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
            } );
              this.dataSourcePh.data = this.ExaminationListPhResult;
      }   
          this.dataSource.filter = value.trim().toLocaleLowerCase();
      }
}
