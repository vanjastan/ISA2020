import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HospitalComponent } from './components/hospital/hospital.component';
import { LOGIN_PATH, REGISTRATION_PATH, USER_HOME_PATH, HOSPITAL_REG, ADMIN_HOME_PATH } from './config/router-paths';
import { AdminHomeComponent} from './components/adminhome/adminhome.component';



const routes: Routes = [
  {
    path: LOGIN_PATH,
    component: LoginComponent
  },
  {
    path: REGISTRATION_PATH,
    component: SignupComponent
  },
  {
    path: HOSPITAL_REG,
    component: HospitalComponent
  },
  {
    path: ADMIN_HOME_PATH,
    component: AdminHomeComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
