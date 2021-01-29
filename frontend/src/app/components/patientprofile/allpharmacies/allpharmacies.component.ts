import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { Pharmacies } from '../../models/pharmacies';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-allpharmacies',
  templateUrl: './allpharmacies.component.html',
  styleUrls: ['./allpharmacies.component.css']
})
export class AllpharmaciesComponent implements OnInit, AfterViewInit {

  Pharmacies: Pharmacies[];
  PharmaciesResults: Pharmacies[];
  name:string;
  address:string;
  city:string;
  rate:string;
  search: string;
  displayedColumns: string[] = ['name', 'address', 'city', 'rate'];

  dataSource = new MatTableDataSource<Pharmacies>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: PharmaciesService, private http: HttpClient) { 
  }

  ngOnInit(): void {
    this.getAllPharmacies();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
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

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Pharmacies;
    }else{
        this.PharmaciesResults = this.Pharmacies.filter( result =>
          { 
            return result.name.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.city.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.PharmaciesResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }
}

