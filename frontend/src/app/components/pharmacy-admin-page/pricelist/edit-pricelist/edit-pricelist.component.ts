import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

@Component({
  selector: 'app-edit-pricelist',
  templateUrl: './edit-pricelist.component.html',
  styleUrls: ['./edit-pricelist.component.css']
})
export class EditPricelistComponent implements OnInit {

  categories = [];

 
  constructor( public dialogRef: MatDialogRef<EditPricelistComponent>, @Inject(MAT_DIALOG_DATA) public data: any,
    private toastr: ToastrService, private service: PharmaciesService) { }

  ngOnInit(): void {
  }

  savePL(): void{
    console.log(this.data);
    this.service.editPricelist(this.data).subscribe(
      data => {
        this.toastr.success("Successfully saved!", "");
        console.log(data);
      },
      error=> console.error('Error updating!',error)
    );
    this.closePL();
  }
  

  closePL(){
    this.dialogRef.close();
  }

}
