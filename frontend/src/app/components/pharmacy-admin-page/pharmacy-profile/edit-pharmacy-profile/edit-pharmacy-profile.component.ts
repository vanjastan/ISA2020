import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';


@Component({
  selector: 'app-edit-pharmacy-profilr',
  templateUrl: './edit-pharmacy-profilr.component.html',
  styleUrls: ['./edit-pharmacy-profilr.component.css']
})
export class EditPharmacyProfileComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<EditPharmacyProfileComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService, private userService: UserService) { }

  ngOnInit(): void {
  }

  closeD(){
    this.dialogRef.close();
    this.toastr.success("Successfully closed!", "");
  }

  /*save(){
    console.log(this.user);
    this.userService.editUsers(this.user).subscribe(
      data => {
        this.toastr.success("Successfully saved!", "");
        console.log(data);
      },
      error=> console.error('Error updating!',error)
    );
    this.closeD();
  }*/

}
