import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Dermatologist } from '../../models/dermatologist';
import { Pharmacies } from '../../models/pharmacies';
import { Pharmacist } from '../../models/pharmacist';

@Component({
  selector: 'app-all-pharmacist',
  templateUrl: './all-pharmacist.component.html',
  styleUrls: ['./all-pharmacist.component.css']
})
export class AllPharmacistComponent implements OnInit {

  Ph: Pharmacist[];
  PhResult: Pharmacist[];

  username: string;
  password: string;
  email: string;
  name: string;
  surname: string;
  address: string;
  number: string;
  city: string;
  country: string;

  phh:Pharmacies;

  id:number;

  search: string;

  displayedColumns: string[] = ['name', 'surname', 'add', 'dismiss'];
  dataSource = new MatTableDataSource<Dermatologist>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllP();
  }

  getAllP(){
    this.service.getAllP().subscribe(data => {
      this.Ph = data;
      this.dataSource.data = data;
      console.log(data);
    });
  }


  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Ph;
    }else{
        this.PhResult = this.Ph.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.surname.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.PhResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

}
