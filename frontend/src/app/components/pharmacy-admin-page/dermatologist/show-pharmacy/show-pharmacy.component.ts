import { Component, OnInit, ViewChild, AfterViewInit, Inject } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../../../models/pharmacies';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Dermatologist } from 'src/app/components/models/dermatologist';

@Component({
  selector: 'app-show-pharmacy',
  templateUrl: './show-pharmacy.component.html',
  styleUrls: ['./show-pharmacy.component.css']
})
export class ShowPharmacyComponent implements OnInit {


  Pharmacies: Pharmacies[];
  PharmaciesResults: Pharmacies[];
  derm:Dermatologist;

  id : number; 

  displayedColumns: string[] = ['name', 'address', 'rate'];
  search: string;

  dataSource = new MatTableDataSource<Pharmacies>();
  @ViewChild(MatSort) sort: MatSort;


  constructor(private service: PharmaciesService, private router: Router,
    public dialogRef: MatDialogRef<ShowPharmacyComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) {
      this.derm = data.Dermatologist;
      this.id = data.id;
      service.getPh(this.id).subscribe(data => {
        this.Pharmacies = data;
        this.dataSource.data = data;
        console.log(this.Pharmacies)
     });
    }

  ngOnInit(): void {
  
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Pharmacies;
    }else{
        this.PharmaciesResults = this.Pharmacies.filter( result =>
          { 
            return result.rate.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.PharmaciesResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }
}
