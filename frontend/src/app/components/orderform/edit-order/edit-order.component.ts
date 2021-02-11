import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { OrderFormService } from 'src/app/services/orderform.service';
import { OrderForm } from '../../models/orderform';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.css']
})
export class EditOrderComponent implements OnInit {

  constructor( public dialogRef: MatDialogRef<EditOrderComponent>, @Inject(MAT_DIALOG_DATA) public data: any,
    private toastr: ToastrService, private service: OrderFormService) { }
  ngOnInit(): void {
  }

  saveEO(){
    console.log(this.data);
    this.service.editOrder(this.data).subscribe(
      data => {
      },
      error=> console.error('Error updating!',error)
    );
    this.closeEO();
  }

  closeEO(){
    this.dialogRef.close();
  }

}
