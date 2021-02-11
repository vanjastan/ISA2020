import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Dermatologist } from '../../models/dermatologist';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { ShowPharmacyComponent } from './show-pharmacy/show-pharmacy.component';
import { ToastrService } from 'ngx-toastr';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

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

  phh:Pharmacies;

  id:number;

  search: string;

  displayedColumns: string[] = ['name', 'surname', 'show'];
  dataSource = new MatTableDataSource<Dermatologist>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog) {
    }

  ngOnInit(): void {
    this.getAllDermos();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllDermos(){
    this.service.getDermatologist().subscribe(data => {
      this.Dermatologists = data;
      this.dataSource.data = data;
      console.log(this.Dermatologists);
    },
    error => {
     console.log("ERROR");
    });
  }


  show(id:number){
    console.log(id);
    let dialogRef = this.dialog.open(ShowPharmacyComponent, {
      width: '1080px',
      data: { Dermatologist: this.Dermatologists, 
              id: id}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
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
