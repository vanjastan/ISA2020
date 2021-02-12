import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { Dermatologist } from 'src/app/components/models/dermatologist';
import { Rate } from 'src/app/components/models/rated';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-rate',
  templateUrl: './rate.component.html',
  styleUrls: ['./rate.component.css']
})
export class RateComponent implements OnInit {

  phh: Dermatologist;
  id:number;

  rate:Rate[];

  displayedColumns: string[] = ['rate'];
  dataSource = new MatTableDataSource<Dermatologist>();



  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: any)  { 
        this.phh = data.pharmacy;
        this.id = data.id;
        service.getRate(this.id).subscribe(data =>{
          this.rate = data;
          this.dataSource.data = data;


        })
  }

  ngOnInit(): void {
  }

}
