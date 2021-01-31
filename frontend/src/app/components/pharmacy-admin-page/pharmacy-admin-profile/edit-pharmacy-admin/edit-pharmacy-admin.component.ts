import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-edit-pharmacy-admin',
  templateUrl: './edit-pharmacy-admin.component.html',
  styleUrls: ['./edit-pharmacy-admin.component.css']
})
export class EditPharmacyAdminComponent implements OnInit {

  categories = [];

  constructor(public dialogRef: MatDialogRef<EditPharmacyAdminComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService, private userService: UserService) { }

  ngOnInit(): void {
  }

  closeDialog(){
    this.dialogRef.close();
  }

  saveChanges(): void{
    this.userService.editAdminPH(this.data).subscribe(
      data => {
        this.toastr.success("Successfully saved!", "");
        console.log(data);
      },
      error=> console.error('Error updating!',error)
    );
    this.closeDialog();
  }
}
