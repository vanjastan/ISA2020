import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Dermatologist } from '../../models/dermatologist';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacist } from '../../models/pharmacist';
import { ShowPHComponent } from './show-ph/show-ph.component';
import { MatDialog } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-pharmacist',
  templateUrl: './pharmacist.component.html',
  styleUrls: ['./pharmacist.component.css']
})
export class PharmacistComponent implements OnInit, AfterViewInit {

  Pharmacists: Pharmacist[];
  PharmacistsResults: Pharmacist[];

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

  displayedColumns: string[] = ['name', 'surname', 'show'];
  dataSource = new MatTableDataSource<Dermatologist>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, private http: HttpClient,  private toastr: ToastrService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.getAllPharm();
  }


  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  shows(id:number){
    let dialogRef = this.dialog.open(ShowPHComponent, {
      width: '1080px',
      data: { Pharmacies: this.Pharmacists, id:id}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  getAllPharm(){
    this.service.getPharmacist().subscribe(data => {
      this.Pharmacists = data;
      this.dataSource.data = data;
      console.log(this.Pharmacists);
    },
    error => {
     console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Pharmacists;
    }else{
        this.PharmacistsResults = this.Pharmacists.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.surname.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.PharmacistsResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }
}
