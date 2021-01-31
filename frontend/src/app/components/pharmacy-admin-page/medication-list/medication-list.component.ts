import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Meds } from '../../../components/medicamentslist/meds'
import { MedsService } from 'src/app/services/meds.service';

@Component({
  selector: 'app-medication-list',
  templateUrl: './medication-list.component.html',
  styleUrls: ['./medication-list.component.css']
})
export class MedicationListComponent implements OnInit, AfterViewInit  {

  Medicaments: Meds[];
  MedicamentsResults: Meds[];
  id: string;
  name: string;
  code: string;
  type: string;
  contradictions: string;
  ingredients: string;
  dailydose: string;
  replacement: string;
  shape: string;
  manufacturer: string;
  issuing: string;
  notes: string;
  quantity: number;
  points: number;

  search: string;

  displayedColumns: string[] = ['code', 'name'];
  dataSource = new  MatTableDataSource<Meds>();
  @ViewChild(MatSort) sort:MatSort;
  
  constructor(private service: MedsService , private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllMedication();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllMedication(){
    this.service.getAllMeds().subscribe(data => {
      this.Medicaments = data;
      this.dataSource.data = data;
      console.log(this.Medicaments);
    },
    error => {
     console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Medicaments;
    }else{
        this.MedicamentsResults = this.Medicaments.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.code.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.MedicamentsResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }
}
