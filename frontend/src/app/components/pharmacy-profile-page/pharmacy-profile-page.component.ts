import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../models/pharmacies';
import { Pharmacist } from '../models/pharmacist';
import { ShowingMedsComponent} from 'src/app/components/pharmacy-profile-page/showing-meds/showing-meds.component';
import { ShowingPharmacistsComponent } from 'src/app/components/pharmacy-profile-page/showing-pharmacists/showing-pharmacists.component';
import { ShowingDermatologistsComponent } from 'src/app/components/pharmacy-profile-page/showing-dermatologists/showing-dermatologists.component';
import { PATIENT_SUBSCRIBE } from 'src/app/config/router-paths';
import { FREE_D_APP } from 'src/app/config/router-paths';


@Component({
  selector: 'app-pharmacy-profile-page',
  templateUrl: './pharmacy-profile-page.component.html',
  styleUrls: ['./pharmacy-profile-page.component.css']
})
export class PharmacyProfilePageComponent implements OnInit {

  ph: Pharmacies;

  pharmacy:Pharmacies[];
  pharmacyResult:Pharmacies[];

  name:string;
  address:string;
  city:string;
  rate:string;
  description: string;
  
  search: string;
  displayedColumns: string[] = [ 'name', 'address', 'city', 'rate', 'showD', 'showP', 'showM', 'showDT'];
  dataSource = new MatTableDataSource<Pharmacies>();
  @ViewChild(MatSort) sort: MatSort;


  constructor(private service: PharmaciesService, public dialog: MatDialog, private http: HttpClient, private toastr: ToastrService, private router: Router) { }

  ngOnInit(): void {
    this.getALLph();
  }

  getALLph(){
    this.service.getPharmacies().subscribe(data =>{
      this.ph = data;
      this.dataSource = data;
    },
    error =>{
      console.log("ERROR");
    });
  }

  showD(id:number){
    console.log(id);
    let dialogRef = this.dialog.open(ShowingDermatologistsComponent, {
      width: '1080px',
      data: { Pharmacies: this.pharmacy, 
              id: id}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  showP(id:number){
    console.log(id);
    let dialogRef = this.dialog.open(ShowingPharmacistsComponent, {
      width: '1080px',
      data: { Pharmacies: this.pharmacy, 
              id: id}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  showM(id:number){
    console.log(id);
    let dialogRef = this.dialog.open(ShowingMedsComponent, {
      width: '1080px',
      data: { Pharmacies: this.pharmacy, 
              id: id}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  showDT(){
    this.router.navigate([FREE_D_APP]);
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.pharmacy;
    }else{
        this.pharmacyResult = this.pharmacy.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.pharmacyResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  showPA(){
    this.router.navigate([PATIENT_SUBSCRIBE]);
  }

}
