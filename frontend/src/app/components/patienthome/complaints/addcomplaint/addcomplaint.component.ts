import { Component, OnInit, Inject, Input } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { from } from 'rxjs';
import { ComplaintService } from 'src/app/services/complaint.service';
import { Complaints } from '../../../models/complaints';

@Component({
  selector: 'app-addcomplaint',
  templateUrl: './addcomplaint.component.html',
  styleUrls: ['./addcomplaint.component.css']
})
export class AddcomplaintComponent implements OnInit {

  complaints= new Complaints(null, null);
  date_of_complaint:string;
  content:string;

  constructor(public dialogRef: MatDialogRef<AddcomplaintComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private service: ComplaintService,
      private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  cancel(){
    this.dialogRef.close();
  }

  save(){
   this.service.saveComplaint(this.complaints).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully added!', '');
    }, error => {
      console.log(error);
    });
  }

}
