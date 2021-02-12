import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Dermatologist } from '../../models/dermatologist';
import { Pharmacies } from '../../models/pharmacies';
import { RateComponent } from 'src/app/components/pharmacy-profile-page/showing-dermatologists/rate/rate.component';

@Component({
  selector: 'app-showing-dermatologists',
  templateUrl: './showing-dermatologists.component.html',
  styleUrls: ['./showing-dermatologists.component.css']
})
export class ShowingDermatologistsComponent implements OnInit {


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

  displayedColumns: string[] = ['name', 'surname', 'showR'];
  dataSource = new MatTableDataSource<Dermatologist>();
  @ViewChild(MatSort) sort:MatSort;


  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: any) { 
      this.phh = data.pharmacy;
      this.id = data.id;
      service.getDerma(this.id).subscribe(data => {
        this.Dermatologists = data;
        this.dataSource.data = data;
        console.log(this.Dermatologists)
      });
    }
  ngOnInit(): void {
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

    showR(id:number){
      console.log(id);
      let dialogRef = this.dialog.open(RateComponent, {
        width: '1080px',
        data: { Pharmacies: this.Dermatologists, 
                id: id}
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('Dialog result: ${result}');
      });

    }

}
