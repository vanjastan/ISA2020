import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { ExaminationsService } from 'src/app/services/examinations.service';
import { Examinations } from '../../models/examination';
import { AddFreeAppComponent } from 'src/app/components/pharmacy-profile-page/derm-appointments/add-free-app/add-free-app.component';


@Component({
  selector: 'app-derm-appointments',
  templateUrl: './derm-appointments.component.html',
  styleUrls: ['./derm-appointments.component.css']
})
export class DermAppointmentsComponent implements OnInit {

 exm = new Examinations(null, null, null, null, null, null);

 Exam: Examinations[];
 ExamResults: Examinations[];

 date:string;

 search:string;
  displayedColumns: string[] = ['date', 'time', 'duration', 'price'];
  dataSource = new MatTableDataSource<Examinations>();
  @ViewChild(MatSort) sort: MatSort;
 

  constructor(public service: ExaminationsService, public dialogMat: MatDialog, private http: HttpClient,
     private toastr: ToastrService,  private router: Router) { }

  ngOnInit(): void {
    this.getAllApp();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllApp(){
    this.service.getFreeExaminations().subscribe(data =>{
      this.Exam = data;
      this.dataSource.data = data;
      console.log(this.Exam);
    },
    error =>{
      console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Exam;
    }else{
        this.ExamResults = this.Exam.filter( result =>
          { 
            return result.date.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.ExamResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  newAPP(){
    let dialogRef = this.dialogMat.open(AddFreeAppComponent, {
      width: '800px',
      height: '500px'

    });
    dialogRef.afterClosed().subscribe(result=> {
      console.log('Dialog result: ${result}');
    });
  }

}
