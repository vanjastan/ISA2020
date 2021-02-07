import { Component, OnInit, ViewChild, AfterViewInit, Inject } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ExaminationsPharmaciest } from 'src/app/components/models/examinationPharm';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../../../models/pharmacies';
import { FREE_PHARMACIEST } from 'src/app/config/router-paths';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-pharmacies-free-derm',
  templateUrl: './pharmacies-free-derm.component.html',
  styleUrls: ['./pharmacies-free-derm.component.css']
})

export class PharmaciesFreeDermComponent implements OnInit, AfterViewInit {

  Pharmacies: Pharmacies[];
  PharmaciesResults: Pharmacies[];
  ExaminationsPharmaciest: ExaminationsPharmaciest[];
  displayedColumns: string[] = ['name', 'address', 'price', 'rate', 'choose'];
  search: string;

  dataSource = new MatTableDataSource<Pharmacies>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: PharmaciesService, private router: Router,
    public dialogRef: MatDialogRef<PharmaciesFreeDermComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit(): void {
    this.getAllPharmacies();
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

    getAllPharmacies(){
      this.service.getPharmacies().subscribe(data => {
        this.Pharmacies = data;
        this.dataSource.data = data;
        console.log(this.Pharmacies);
      },
      error => {
       console.log("ERROR");
      });
    }

    choose(){
      this.router.navigate([FREE_PHARMACIEST]);
      this.dialogRef.close();
    }
}
