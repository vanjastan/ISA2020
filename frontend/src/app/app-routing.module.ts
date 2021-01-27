import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HospitalComponent } from './components/hospital/hospital.component';
import { LOGIN_PATH, REGISTRATION_PATH, USER_HOME_PATH, HOSPITAL_REG, ADMIN_HOME_PATH, SUPPLIER_HOME_PATH, SUPPLIER_PROFILE_PATH, 
MEDICAMENTS_LIST_PATH, ADMIN_REG_PATH, ADMIN_REG_DERM_PATH, ADMIN_REG_ADMIN_PATH, PATIENT_HOME_PATH, PATIENT_PROFILE_PATH,
PATIENT_PROFILE_PHARMACIES,
PATIENT_PROFILE_EXAMINATIONS,
PATIENT_PROFILE_EXAMINATIONS_PHARMACIEST} from './config/router-paths';
import { AdminHomeComponent} from './components/adminhome/adminhome.component';
import {SupplierHomeComponent} from './components/supplierhome/supplierhome.component';
import {SupplierProfileComponent} from './components/supplierprofile/supplierprofile.component';
import { MedicamentsListComponent} from './components/medicamentslist/medicamentslist.component';
import { AdminRegComponent } from './components/adminreg/adminreg.component';
import { AdminRegDermComponent} from './components/adminregderm/adminregderm.component';
import { AdminAddComponent} from './components/adminhome/addadmin.component';
import { PatienthomeComponent } from './components/patienthome/patienthome.component';
import { PatientprofileComponent } from './components/patientprofile/patientprofile.component';
import { AllpharmaciesComponent } from './components/patientprofile/allpharmacies/allpharmacies.component';
import { ExaminationsComponent } from './components/patientprofile/examinations/examinations.component';
import { ExaminationsPharmComponent } from './components/patientProfile/examinations-pharm/examinations-pharm.component';

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
    path: PATIENT_HOME_PATH,
    component: PatienthomeComponent
  },
  {
    path: PATIENT_PROFILE_PATH,
    component: PatientprofileComponent
  },
  {
    path: PATIENT_PROFILE_PHARMACIES,
    component: AllpharmaciesComponent
  },
  {
    path: PATIENT_PROFILE_EXAMINATIONS,
    component: ExaminationsComponent
  },
  {
    path: PATIENT_PROFILE_EXAMINATIONS_PHARMACIEST,
    component: ExaminationsPharmComponent
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
  {
    path: ADMIN_REG_ADMIN_PATH,
    component: AdminAddComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
