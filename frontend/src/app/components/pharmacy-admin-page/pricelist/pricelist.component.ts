import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild, Inject } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { PriceList } from 'src/app/components/models/pricelist';
import { PharmaciesService } from 'src/app/services/pharmacies.service';
import { EditPricelistComponent } from 'src/app/components/pharmacy-admin-page/pricelist/edit-pricelist/edit-pricelist.component';
import { ToastrService } from 'ngx-toastr';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-pricelist',
  templateUrl: './pricelist.component.html',
  styleUrls: ['./pricelist.component.css']
})
export class PricelistComponent implements OnInit, AfterViewInit {


  PriceList: PriceList[];
  PriceListResults: PriceList[];

  price:number;
  //id:number;

  from_date:string;
  to_date:string;

  search:string;
  categories = [];

  pricelist: PriceList;

  displayedColumns: string[] = ['name','price', 'from_date', 'to_date', 'edit'];
  dataSource = new MatTableDataSource<PriceList>();
  @ViewChild(MatSort) sort:MatSort;

  constructor(private service: PharmaciesService, private http: HttpClient,
    public dialog: MatDialog, private toastr: ToastrService, private router: Router  ) { }

  ngOnInit(): void {
    this.getAllPrice();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllPrice(){
    this.service.getPrice().subscribe(data => {
      this.pricelist = data;
      this.dataSource = data;
    },
    console=>{
      console.log("ERROR");
    });
  }

  edit(id: number, price: number, from_date:string, to_date:string): void{
    console.log(id);
    let dialogRef = this.dialog.open(EditPricelistComponent, {
      width: '650px',
      data: {id:id, price:price, from_date:from_date, to_date:to_date}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }


  doFilter = (value:string)=>{
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
