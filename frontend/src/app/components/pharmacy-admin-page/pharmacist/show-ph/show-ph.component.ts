import { Component, OnInit, ViewChild, AfterViewInit, Inject } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../../../models/pharmacies';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Pharmacist } from 'src/app/components/models/pharmacist';

@Component({
  selector: 'app-show-ph',
  templateUrl: './show-ph.component.html',
  styleUrls: ['./show-ph.component.css']
})
export class ShowPHComponent implements OnInit {

  
  Pharmacies: Pharmacies[];
  PharmaciesResults: Pharmacies[];

  pharm:Pharmacist;
  id:number;

  displayedColumns: string[] = ['name', 'address', 'rate'];
  search: string;

  dataSource = new MatTableDataSource<Pharmacies>();
  @ViewChild(MatSort) sort: MatSort;


  constructor(private service: PharmaciesService, private router: Router,
    public dialogRef: MatDialogRef<ShowPHComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { 
        this.pharm = data.Pharmacist;
        this.id = data.id;
        service.getPhamr(this.id).subscribe(data =>{
          this.Pharmacies = data;
          this.dataSource.data = data;
          console.log(this.Pharmacies)
        });

    }

  ngOnInit(): void {
   // this.getPharmacies();
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

   /* getPharmacies(){
      this.service.getPhamr().subscribe(data => {
        this.Pharmacies = data;
        this.dataSource.data = data;
        console.log(this.Pharmacies);
      },
      error => {
       console.log("ERROR");
      });
    }*/

}
