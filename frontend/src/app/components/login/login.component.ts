import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import LoginDTO from '../models/login-dto.model';
import { USER_ID_KEY, USER_ROLE_KEY, USERNAME_KEY, USER_TOKEN_KEY } from 'src/app/config/local-storage-keys';
import { ROLE_ADMIN,  ROLE_USER, ROLE_SUPPLIER, ROLE_PATIENT, ROLE_ADMINPH } from 'src/app/config/user-roles-keys';
import { ADMIN_HOME_PATH,  USER_HOME_PATH, SUPPLIER_HOME_PATH, PATIENT_HOME_PATH, ADMINPH_HOME_PATH } from 'src/app/config/router-paths';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loginSuccess: boolean = false;
  loginError: boolean = false;
  toastr: any;

  constructor(private fb: FormBuilder,
              private router: Router,
              private authService: AuthService) {

    this.createForm();
  }

  ngOnInit(): void {
  }

  private createForm(): void {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  onLogin(): void {
    const credentials: LoginDTO = {
      username: this.loginForm.value.username,
      password: this.loginForm.value.password
    };

    this.authService.login(credentials).subscribe(data => {
      console.log("DATA: ", data);
      localStorage.setItem(USER_ID_KEY, data.id);
      localStorage.setItem(USER_ROLE_KEY, data.authorities[0]);
      localStorage.setItem(USERNAME_KEY, data.username);
      localStorage.setItem(USER_TOKEN_KEY, data.token.accessToken);

      this.loginSuccess = true;
      this.loginError = false;

      switch (data.authorities[0]) {
        case ROLE_ADMIN:  this.router.navigate([ADMIN_HOME_PATH]); break;
        case ROLE_USER: this.router.navigate([USER_HOME_PATH]); break;
        case ROLE_SUPPLIER: this.router.navigate([SUPPLIER_HOME_PATH]); break;
        case ROLE_PATIENT: this.router.navigate([PATIENT_HOME_PATH]); break;
        case ROLE_ADMINPH : this.router.navigate([ADMINPH_HOME_PATH]); break;
      }
    }, error => {
      this.loginSuccess = false;
      this.loginError = true;
      //this.toastr.error(error.error.message);
    });
  }

}
