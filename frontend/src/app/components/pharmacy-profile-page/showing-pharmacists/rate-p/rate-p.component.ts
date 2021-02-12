import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
import { ToastrService } from 'ngx-toastr';
import { Pharmacist } from 'src/app/components/models/pharmacist';
import { Rate } from 'src/app/components/models/rated';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-rate-p',
  templateUrl: './rate-p.component.html',
  styleUrls: ['./rate-p.component.css']
})
export class RatePComponent implements OnInit {

  phh: Pharmacist;
  id:number;

  rate:Rate[];

  displayedColumns: string[] = ['rate'];
  dataSource = new MatTableDataSource<Pharmacist>();



  constructor(private service: PharmaciesService, 
    private http: HttpClient, private toastr: ToastrService, 
    public dialog: MatDialog, @Inject(MAT_DIALOG_DATA) public data: any)  { 
        this.phh = data.pharmacy;
        this.id = data.id;
        service.getRateP(this.id).subscribe(data =>{
          this.rate = data;
          this.dataSource.data = data;


        })
  }
  ngOnInit(): void {
  }

}
