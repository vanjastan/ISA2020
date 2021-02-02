import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {

  categories = [];

  constructor(public dialogRef: MatDialogRef<EditprofileComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService, private userService: UserService) { }

  ngOnInit(): void {
  }

  closeD(){
    this.dialogRef.close();
  }

  save(): void{
    this.userService.editUsers(this.data).subscribe(
      data => {
        this.toastr.success("Successfully saved!", "");
        console.log(data);
      },
      error=> console.error('Error updating!',error)
    );
    this.closeD();
  }
}
