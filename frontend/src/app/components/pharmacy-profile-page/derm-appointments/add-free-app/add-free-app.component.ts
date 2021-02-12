import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ToastrService } from 'ngx-toastr';
import { Examinations } from 'src/app/components/models/examination';
import { ExaminationsService } from 'src/app/services/examinations.service';

@Component({
  selector: 'app-add-free-app',
  templateUrl: './add-free-app.component.html',
  styleUrls: ['./add-free-app.component.css']
})
export class AddFreeAppComponent implements OnInit {

  app =new Examinations(null, null, null, null, null, null);


    constructor(public dialogRef: MatDialogRef<AddFreeAppComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private service: ExaminationsService,
      private toastr: ToastrService) { }

  ngOnInit(): void {
  }

  cancelAPP(){
    this.dialogRef.close();
  }

  saveAPP(){
   this.service.saveApp(this.app).subscribe(data =>{
      console.log(data);
      this.toastr.success('Successfully added!', '');
    }, error => {
      console.log(error);
    });
  }

}
