import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { OrderForm } from 'src/app/components/models/orderform';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { OrderFormService } from 'src/app/services/orderform.service';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AddOrderformComponent } from 'src/app/components/orderform/add-orderform/add-orderform.component';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-orderform',
  templateUrl: './orderform.component.html',
  styleUrls: ['./orderform.component.css']
})
export class OrderformComponent implements OnInit {

  Orderform: OrderForm[];
  OrderformResult: OrderForm[];

  medicament_name:string;
  medicament_id: number;
  quantity:number;
  end_date:string;
  status: string;

  search: string;
  displayedColumns: string[] = ['name', 'end_date', 'status', 'quantity'];
  dataSource = new MatTableDataSource<OrderForm>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: OrderFormService, public dialogMat: MatDialog, private http: HttpClient, private toastr: ToastrService,  private router: Router,) { }

  ngOnInit(): void {
    this.getAllOrder();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllOrder(){
    this.service.getAllOF().subscribe(data =>{
      this.Orderform = data;
      this.dataSource.data = data;
      console.log(this.Orderform);
    },
    error =>{
      console.log("ERROR");
    });
  }

  public doFilter = (value:string)=>{
    if(this.search == ""){
        this.dataSource.data = this.Orderform;
    }else{
        this.OrderformResult = this.Orderform.filter( result =>
          { 
            return result.status.toLocaleLowerCase().match(this.search.toLocaleLowerCase()) 
          } );
            this.dataSource.data = this.OrderformResult;
    }   
        this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  order(): void{
    let dialogRef = this.dialogMat.open(AddOrderformComponent, {
      width: '800px',
      height: '500px'
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }


}


