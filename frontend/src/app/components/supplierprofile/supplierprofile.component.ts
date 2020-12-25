import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-supplierprofile',
  templateUrl: './supplierprofile.component.html',
  styleUrls: ['./supplierprofile.component.css']
})
export class SupplierProfileComponent implements OnInit {

  categories = [];
  user: User = new User("","","","","","","","","");
  form: FormGroup;
  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder, private authService: AuthService) { }

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
    this.userService.editUsers(this.user)
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
}