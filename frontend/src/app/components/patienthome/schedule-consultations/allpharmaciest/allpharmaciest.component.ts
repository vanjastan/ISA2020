import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Pharmacist } from 'src/app/components/models/pharmacist';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-allpharmaciest',
  templateUrl: './allpharmaciest.component.html',
  styleUrls: ['./allpharmaciest.component.css']
})
export class AllpharmaciestComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['name', 'surname', 'rate', 'choose'];
  search: string;
  Pharmacist: Pharmacist[];
  PharmacistResult: Pharmacist[];

  dataSource = new MatTableDataSource<Pharmacist>();
  @ViewChild(MatSort) sort: MatSort;
  constructor() { }

  ngOnInit(): void {
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Pharmacist;
    }else{
        this.PharmacistResult = this.Pharmacist.filter( result =>
          { 
            return result.rate.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.PharmacistResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    choose(){
      
    }
}
