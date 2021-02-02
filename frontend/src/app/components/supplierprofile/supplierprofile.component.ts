import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Supplier } from '../models/supplier';
import { AuthService } from 'src/app/services/auth.service';
import { MatDialog } from '@angular/material/dialog';
import { EditpassSupComponent } from './editPassSup/editPassSup.component';

@Component({
  selector: 'app-supplierprofile',
  templateUrl: './supplierprofile.component.html',
  styleUrls: ['./supplierprofile.component.css']
})
export class SupplierProfileComponent implements OnInit {

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  categories = [];
  user: Supplier = new Supplier(1,"","","","","","","","","");
  form: FormGroup;
  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder, private authService: AuthService, public dialog: MatDialog,
    public dialogPass: MatDialog) { }

  ngOnInit() {
    this.getUserInfo();
    this.form = this.formBuilder.group({
      oldPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
      newPassword: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])],
      email: String
    });
  }

  private getUserInfo(): void {
    this.userService.getUserInfo().subscribe(data => {
      this.user = data;
    }, error => {
      console.log("Error in getting user data!")
    });
  }

  onClickSave(){
    this.userService.editUser(this.user)
    .subscribe(
      data=> {
        alert('Request has been sent!');
          console.log('Updated!', JSON.stringify(data));
        },
        error=> console.error('Error updating!',error)
    ) 
  }

  onClickCancel(){
      this.router.navigate(['/supplier']);
  }

  changePass(id: number, name: string, surname: string, username: string,
    email: string, password: string, address: string, city: string, country: string, number: string) : void{
    let dialogRef = this.dialog.open(EditpassSupComponent, {
      width: '650px',
      data: { id: id, password: password, name: name, surname: surname, 
        username: username, address: address, city: city, country: country,
        number: number, email: email }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('Dialog result: ${result}');
    });
  }
}