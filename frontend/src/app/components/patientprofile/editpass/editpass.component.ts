import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog'; 
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-editpass',
  templateUrl: './editpass.component.html',
  styleUrls: ['./editpass.component.css']
})
export class EditpassComponent implements OnInit {

  newPass: string;
  confirmedPass: string;

  constructor(public dialogRef: MatDialogRef<EditpassComponent>, 
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
      this.service.setNewPass(this.data).subscribe(
        res =>{
          this.toastr.success("Successfully changed!", '');
        }
      );
    }
    this.closeD();
  }

  closeD(): void{
    this.dialogRef.close();
    this.toastr.success("Successfully closed!", '');
  }
}
