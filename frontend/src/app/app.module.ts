import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { MatSliderModule } from '@angular/material/slider';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatTableModule } from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatList, MatListModule} from '@angular/material/list';
import {MatIconModule} from '@angular/material/icon';
import {MatSelect, MatSelectModule} from '@angular/material/select';
import {MatNativeDateModule} from '@angular/material/core';
import { MatMomentDateModule } from "@angular/material-moment-adapter";
import {MatCardModule} from '@angular/material/card';
import {MatCheckboxModule} from '@angular/material/checkbox';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {FlexLayoutModule} from '@angular/flex-layout';

import { HeaderComponent } from './components/header/header.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HospitalComponent } from './components/hospital/hospital.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AddTokenInterceptor } from './interceptors/http-interceptor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AdminHomeComponent} from './components/adminhome/adminhome.component';
import { SupplierHomeComponent} from './components/supplierhome/supplierhome.component';
import { SupplierProfileComponent} from './components/supplierprofile/supplierprofile.component';
import { MedicamentsListComponent} from './components/medicamentslist/medicamentslist.component';
import { AdminRegComponent} from './components/adminreg/adminreg.component';
import { AdminRegDermComponent} from './components/adminregderm/adminregderm.component';
import { AdminAddComponent} from './components/adminhome/addadmin.component';
import { SupplierTenderComponent} from './components/suppliertender/suppliertender.component';

import { PatienthomeComponent } from './components/patienthome/patienthome.component';
import { PatientprofileComponent } from './components/patientprofile/patientprofile.component';
import { EditprofileComponent } from './components/patientprofile/editprofile/editprofile.component';
import { EditpassComponent } from './components/patientprofile/editpass/editpass.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { AllpharmaciesComponent } from './components/patientprofile/allpharmacies/allpharmacies.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { ExaminationsComponent } from './components/patientprofile/examinations/examinations.component';
import { ExaminationsPharmComponent } from './components/patientProfile/examinations-pharm/examinations-pharm.component';
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { SheduledExaminationsComponent } from './components/patienthome/sheduled-examinations/sheduled-examinations.component';
import { ReservedMedsComponent } from './components/patienthome/reserved-meds/reserved-meds.component';
import { PenalsComponent } from './components/patienthome/penals/penals.component';
import { EMedsComponent } from './components/patienthome/e-meds/e-meds.component';
import { SubscribedPharmaciesComponent } from './components/patienthome/subscribed-pharmacies/subscribed-pharmacies.component';
import { ComplaintsComponent } from './components/patienthome/complaints/complaints.component';
import { TakeMedicineComponent } from './components/patienthome/take-medicine/take-medicine.component';
import { ScheduleConsultationsComponent } from './components/patienthome/schedule-consultations/schedule-consultations.component';
import { ScheduleExaminationsComponent } from './components/patienthome/schedule-examinations/schedule-examinations.component';
import { PharmacyAdminPageComponent } from './components/pharmacy-admin-page/pharmacy-admin-page.component';
import { PharmacyProfileComponent } from './components/pharmacy-admin-page/pharmacy-profile/pharmacy-profile.component';
import { MedicationListComponent } from './components/pharmacy-admin-page/medication-list/medication-list.component';
import { PharmacyAdminProfileComponent } from './components/pharmacy-admin-page/pharmacy-admin-profile/pharmacy-admin-profile.component';
import { EditPharmacyAdminComponent } from './components/pharmacy-admin-page/pharmacy-admin-profile/edit-pharmacy-admin/edit-pharmacy-admin.component';
import { ShowcomplaintsComponent } from './components/patienthome/complaints/showcomplaints/showcomplaints.component';
import { AddcomplaintComponent } from './components/patienthome/complaints/addcomplaint/addcomplaint.component';
import { AlergiesComponent } from './components/patientprofile/alergies/alergies.component';
import { LoyaltyprogramComponent } from './components/patientprofile/loyaltyprogram/loyaltyprogram.component';
//import { EditPharmacyProfileComponent } from './components/pharmacy-admin-page/pharmacy-profile/edit-pharmacy-profile/edit-pharmacy-profile.component';
//import { ChangePasswordComponent } from './components/pharmacy-admin-page/pharmacy-profile/change-password/change-password.component';
import { Header1Component } from './components/header1/header1.component';
import { Header2Component } from './components/header2/header2.component';
import { Header3Component } from './components/header3/header3.component';
import { EditpassSupComponent } from './components/supplierprofile/editPassSup/editPassSup.component';
import { ChangeAdminphPasswordComponent } from './components/pharmacy-admin-page/pharmacy-admin-profile/change-adminph-password/change-adminph-password.component';
import { ActionsAndPromotionsComponent } from './components/pharmacy-admin-page/actions-and-promotions/actions-and-promotions.component';
import { AddActionsAndPromotionsComponent } from './components/pharmacy-admin-page/actions-and-promotions/add-actions-and-promotions/add-actions-and-promotions.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    SignupComponent,
    HospitalComponent,
    AdminHomeComponent,
    SupplierHomeComponent,
    SupplierProfileComponent,
    MedicamentsListComponent,
    AdminRegComponent,
    AdminRegDermComponent,
    AdminAddComponent,
    SupplierTenderComponent,
    PatienthomeComponent,
    PatientprofileComponent,
    EditprofileComponent,
    EditpassComponent,
    AllpharmaciesComponent,
    ExaminationsComponent,
    ExaminationsPharmComponent,
    PrescriptionsComponent,
    SheduledExaminationsComponent,
    ReservedMedsComponent,
    PenalsComponent,
    EMedsComponent,
    SubscribedPharmaciesComponent,
    ComplaintsComponent,
    TakeMedicineComponent,
    ScheduleConsultationsComponent,
    ScheduleExaminationsComponent,
    PharmacyAdminPageComponent,
    PharmacyProfileComponent,
    MedicationListComponent,
    PharmacyAdminProfileComponent,
    EditPharmacyAdminComponent,
    ShowcomplaintsComponent,
    AddcomplaintComponent,
    AlergiesComponent,
    LoyaltyprogramComponent,
   // EditPharmacyProfileComponent,
   // ChangePasswordComponent,
    Header1Component,
    Header2Component,
    Header3Component,
    EditpassSupComponent,
   ChangeAdminphPasswordComponent,
   ActionsAndPromotionsComponent,
   AddActionsAndPromotionsComponent,

   ChangeAdminphPasswordComponent

  ],
  entryComponents: [
    EditprofileComponent,
    EditpassComponent,
    ShowcomplaintsComponent,
    AddcomplaintComponent,
    AlergiesComponent,
    LoyaltyprogramComponent,
    EditpassSupComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    NgbModule,
    RouterModule,
    FlexLayoutModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatTableModule,
    MatSortModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatSelectModule,
    MatPaginatorModule,
    MatNativeDateModule,
    MatMomentDateModule,
    MatCardModule,
    MatCheckboxModule,
    ToastrModule.forRoot()
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AddTokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
