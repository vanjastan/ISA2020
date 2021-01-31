import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-change-adminph-password',
  templateUrl: './change-adminph-password.component.html',
  styleUrls: ['./change-adminph-password.component.css']
})
export class ChangeAdminphPasswordComponent implements OnInit {

  newPassword: string;
  confirmedPassword: string;

  constructor(public dialogRef: MatDialogRef<ChangeAdminphPasswordComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService, private service: UserService) { }

  ngOnInit(): void {
  }

  savePassword(){
    if(this.newPassword == "" || this.confirmedPassword == ""){
      alert('You have not entered all parameters!'); 
    }else if(this.newPassword != this.confirmedPassword){
      alert('Passwords do not match!');
    }else {
      this.data.password = this.newPassword;
      this.service.setNewPassword(this.data).subscribe(
        res =>{
          this.toastr.success("Successfully changed!", '');
        }
      );
    }
    this.closeP();
  }

  closeP(): void{
    this.dialogRef.close();
    this.toastr.success("Successfully closed!", '');
  }
}
