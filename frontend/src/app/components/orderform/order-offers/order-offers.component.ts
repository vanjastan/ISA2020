import { HttpClient } from '@angular/common/http';
import { Route } from '@angular/compiler/src/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { OrderFormService } from 'src/app/services/orderform.service';
import { OrderOffers } from '../../models/OrderOffers';

@Component({
  selector: 'app-order-offers',
  templateUrl: './order-offers.component.html',
  styleUrls: ['./order-offers.component.css']
})
export class OrderOffersComponent implements OnInit {

  offers : OrderOffers[];
  offersResult:OrderOffers[];

  price:number;
  order:number;
  
  search: string;
  displayedColumns: string[] = ['id', 'price', 'chooseOffer'];
  dataSource = new MatTableDataSource<OrderOffers>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: OrderFormService, public dialogMat: MatDialog, private http: HttpClient, private toastr: ToastrService,  private router: Router) { }

  ngOnInit(): void {
    this.getAllOffers();
  }

  chooseOffer(id:number){
      this.service.chooseOF(id).subscribe(data => {
        console.log(data);
        this.toastr.success('Successfully choosen!', '');
      });
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllOffers(){
    this.service.getAllOffer().subscribe(data =>{
      this.offers = data;
      this.dataSource = data;
    },
    error =>{
      console.log("ERROR");
    });
  }


  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.offers;
    }else{
        this.offersResult = this.offers.filter( result =>
          { 
           
          } );
            this.dataSource.data = this.offersResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
  }
}

