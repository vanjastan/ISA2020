import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Medicine } from '../../models/medicine';
import { Pharmacies } from '../../models/pharmacies';

@Component({
  selector: 'app-showing-meds',
  templateUrl: './showing-meds.component.html',
  styleUrls: ['./showing-meds.component.css']
})
export class ShowingMedsComponent implements OnInit {

  Meds: Medicine[];
  MedsResults: Medicine[];

  id: number;
  name: string;
  code: string;
  type: string;
  contradictions: string;
  ingredients: string;
  dailydose: string;
  replacement: string;
  shape: string;
  manufacturer: string;
  issuing: string
  notes: string;
  quantity: number;
  points: number;

  phh:Pharmacies;

  search: string;

  displayedColumns: string[] = ['name', 'type'];
  dataSource = new MatTableDataSource<Medicine>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: any)  { 
        this.phh = data.pharmacy;
        this.id = data.id;
        service.getMeds(this.id).subscribe(data =>{
          this.Meds = data;
          this.dataSource.data =data;
        })

  }

  ngOnInit(): void {
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Meds;
    }else{
        this.MedsResults = this.Meds.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.MedsResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }
}
