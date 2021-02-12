import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../../models/pharmacies';
import { Pharmacist } from '../../models/pharmacist';
import { RatePComponent } from 'src/app/components/pharmacy-profile-page/showing-pharmacists/rate-p/rate-p.component';

@Component({
  selector: 'app-showing-pharmacists',
  templateUrl: './showing-pharmacists.component.html',
  styleUrls: ['./showing-pharmacists.component.css']
})
export class ShowingPharmacistsComponent implements OnInit {

  Ph: Pharmacist[];
  PhResults: Pharmacist[];

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
  dataSource = new MatTableDataSource<Pharmacist>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: any) { 
          this.phh = data.pharmacy;
          this.id = data.id;
          service.getPharmaciests(this.id).subscribe(data =>{
            this.Ph = data;
            this.dataSource.data = data;
          });
  }

  ngOnInit(): void {
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Ph;
    }else{
        this.PhResults = this.Ph.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.surname.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.PhResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

    showR(id:number){
      console.log(id);
      let dialogRef = this.dialog.open(RatePComponent, {
        width: '1080px',
        data: { Pharmacies: this.Ph, 
                id: id}
      });
      dialogRef.afterClosed().subscribe(result => {
        console.log('Dialog result: ${result}');
      });

    }

}
