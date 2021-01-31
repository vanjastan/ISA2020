import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

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
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatNativeDateModule} from '@angular/material/core';
import { MatMomentDateModule } from "@angular/material-moment-adapter";

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

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
  ],
  imports: [
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatToolbarModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    NgbModule,
    RouterModule,
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
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AddTokenInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
