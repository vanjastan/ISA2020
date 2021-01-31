import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-editPassSup',
  templateUrl: './editPassSup.component.html',
  styleUrls: ['./editPassSup.component.css']
})
export class EditpassSupComponent implements OnInit {

  newPass: string;
  confirmedPass: string;

  constructor(public dialogRef: MatDialogRef<EditpassSupComponent>, 
    @Inject(MAT_DIALOG_DATA) public data: any, private toastr: ToastrService, private service: UserService) { }

  ngOnInit(): void {
  }

  savePass(){
    if(this.newPass == "" || this.confirmedPass == ""){
      alert('You have not entered all parameters!'); 
    }else if(this.newPass != this.confirmedPass){
      alert('Passwords do not match!');
    }else {
      this.data.password = this.newPass;
      this.service.setPassSup(this.data).subscribe(
        res =>{
          this.toastr.success("Successfully changed!", '');
        }
      );
    }

  }

  closeD(): void{
    this.dialogRef.close();
    this.toastr.success("Successfully closed!", '');
  }
}