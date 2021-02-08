import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild, } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { PriceList } from 'src/app/components/models/pricelist';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-pricelist',
  templateUrl: './pricelist.component.html',
  styleUrls: ['./pricelist.component.css']
})
export class PricelistComponent implements OnInit, AfterViewInit {


  PriceList: PriceList[];
  PriceListResults: PriceList[];

  price:number;
  from_date:string;
  to_date:string;

  search:string;

  displayedColumns: string[] = ['price', 'from_date', 'to_date'];
  dataSource = new MatTableDataSource<PriceList>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, private http: HttpClient) { }

  ngOnInit(): void {
    this.getAllPrice();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllPrice(){
    this.service.getPrice().subscribe(data => {
      this.PriceList = data;
      this.dataSource = data;
      console.log(this.PriceList);
    },
    console=>{
      console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.PriceList;
    }else{
        this.PriceListResults = this.PriceList.filter( result =>
          { 
            return result.from_date.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) ||
              result.to_date.toLocaleLowerCase().match(this.search.toLocaleLowerCase())
          } );
            this.dataSource.data = this.PriceListResults;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
    }

}
