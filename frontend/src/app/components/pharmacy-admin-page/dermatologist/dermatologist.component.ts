import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Dermatologist } from '../../models/dermatologist';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-dermatologist',
  templateUrl: './dermatologist.component.html',
  styleUrls: ['./dermatologist.component.css']
})
export class DermatologistComponent implements OnInit, AfterViewInit {

  Dermatologists: Dermatologist[];
  DermatologistResults: Dermatologist[];
  
  username: string;
  password: string;
  email: string;
  name: string;
  surname: string;
  address: string;
  number: string;
  city: string;
  country: string;

  search: string;

  displayedColumns: string[] = ['name', 'surname'];
  dataSource = new MatTableDataSource<Dermatologist>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllDerm();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllDerm(){
    this.service.getDermatologist().subscribe(data => {
      this.Dermatologists = data;
      this.dataSource.data = data;
      console.log(this.Dermatologists);
    },
    error => {
     console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Dermatologists;
    }else{
        this.DermatologistResults = this.Dermatologists.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.surname.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.DermatologistResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

}