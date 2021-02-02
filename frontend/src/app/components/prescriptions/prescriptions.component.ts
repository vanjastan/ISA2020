import { Prescription } from '../models/prescription';
import { MatSort } from '@angular/material/sort';
import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PrescriptionsService } from 'src/app/services/prescriptions.service';

@Component({
  selector: 'app-prescriptions',
  templateUrl: './prescriptions.component.html',
  styleUrls: ['./prescriptions.component.css']
})
export class PrescriptionsComponent implements OnInit, AfterViewInit {

  PrescriptionList: Prescription[];
  PrescriptionResults: Prescription[];
  date_of_pub: string;
  status: string;
  patientId: number;
  search: string;
  displayedColumns: string[] = ['date', 'status'];
  dataSource = new MatTableDataSource<Prescription>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private pService: PrescriptionsService) { }

  ngOnInit(): void {
    this.getPrescriptions();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getPrescriptions(){
    this.getPatientId();
     this.pService.getPrescriptions(this.patientId).subscribe(data=>{
      this.PrescriptionList = data;
      this.dataSource.data = data;
      console.log(data);
    })
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.PrescriptionList;
    }else{
        this.PrescriptionResults = this.PrescriptionList.filter( result =>
          { 
            return result.date_of_pub.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
             result.status.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.PrescriptionResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    public getPatientId(){
      this.pService.getPatient().subscribe(data =>{
          this.patientId = data.id;
      })
    }
}
