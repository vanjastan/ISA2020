import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HospitalComponent } from './components/hospital/hospital.component';
import { LOGIN_PATH, REGISTRATION_PATH, USER_HOME_PATH, HOSPITAL_REG, ADMIN_HOME_PATH, SUPPLIER_HOME_PATH, SUPPLIER_PROFILE_PATH, 
MEDICAMENTS_LIST_PATH, ADMIN_REG_PATH, ADMIN_REG_DERM_PATH} from './config/router-paths';
import { AdminHomeComponent} from './components/adminhome/adminhome.component';
import {SupplierHomeComponent} from './components/supplierhome/supplierhome.component';
import {SupplierProfileComponent} from './components/supplierprofile/supplierprofile.component';
import { MedicamentsListComponent} from './components/medicamentslist/medicamentslist.component';
import { AdminRegComponent } from './components/adminreg/adminreg.component';
import { AdminRegDermComponent} from './components/adminregderm/adminregderm.component';

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
  {
    path: SUPPLIER_HOME_PATH,
    component: SupplierHomeComponent
  },
  {
    path: SUPPLIER_PROFILE_PATH,
    component: SupplierProfileComponent
  },
  {
    path: MEDICAMENTS_LIST_PATH,
    component: MedicamentsListComponent
  },
  {
    path: ADMIN_REG_PATH,
    component: AdminRegComponent
  },
  {
    path: ADMIN_REG_DERM_PATH,
    component: AdminRegDermComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
