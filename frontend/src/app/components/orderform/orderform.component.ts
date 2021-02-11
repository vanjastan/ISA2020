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
import { EditOrderComponent } from './edit-order/edit-order.component';


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

  orders: OrderForm;

  search: string;
  displayedColumns: string[] = ['id', 'name', 'end_date', 'status', 'quantity', 'edit', 'delete'];
  dataSource = new MatTableDataSource<OrderForm>();
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: OrderFormService, public dialog: MatDialog, private http: HttpClient, private toastr: ToastrService,  private router: Router,) { }

  ngOnInit(): void {
    this.getAllOrder();
  }

  ngAfterViewInit(): void{
    this.dataSource.sort = this.sort;
  }

  getAllOrder(){
    this.service.getAllOF().subscribe(data =>{
      this.orders = data;
      this.dataSource = data;
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
    let dialogRef = this.dialog.open(AddOrderformComponent, {
      width: '800px',
      height: '500px'
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }

  editEO(id:number, medicament_name:string,  quantity: number, end_date:string): void{
    let dialogRef = this.dialog.open(EditOrderComponent, {
      width: '650px',
      data: {id:id, medicament_name:medicament_name, quantity:quantity, end_date:end_date}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }


  deleteEO(id:number){
    this.service.deleteOF(id).subscribe( data =>{
      console.log(data);
      this.toastr.success('Successfully deleted!', '');
    },
    error => {
      console.log(error);
        
    });
  }


}


