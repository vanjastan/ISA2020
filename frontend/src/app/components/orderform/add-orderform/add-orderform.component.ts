import { Component, OnInit, Inject } from '@angular/core';
import { OrderForm } from 'src/app/components/models/orderform';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { OrderFormService } from 'src/app/services/orderform.service';

@Component({
  selector: 'app-add-orderform',
  templateUrl: './add-orderform.component.html',
  styleUrls: ['./add-orderform.component.css']
})
export class AddOrderformComponent implements OnInit {

  orderform = new OrderForm(null, null, null);
  medicament_name:string;
  quantity:number;
  end_date:string;

  constructor(public dialogRef: MatDialogRef<AddOrderformComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private service: OrderFormService,
      private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  cancelOF(){
    this.dialogRef.close();
  }

  saveOF(){
   this.service.saveOrderForm(this.orderform).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully added!', '');
    }, error => {
      console.log(error);
    });
  }
  

}
