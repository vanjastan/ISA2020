import { NgModule, ɵclearResolutionOfComponentResourcesQueue } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {LoginComponent} from '../app/components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HospitalComponent } from './components/hospital/hospital.component';

import { LOGIN_PATH, HEADER, HEADER1, HEADER2, REGISTRATION_PATH, USER_HOME_PATH, HOSPITAL_REG, ADMIN_HOME_PATH, 

SUPPLIER_HOME_PATH, SUPPLIER_PROFILE_PATH, PHARMACY_HOMEPAGE, PHARMACY_PAGE,
DERMATOLOGIST, PHARMACIST, PHARMACY_INFO, ADMINPH_ORDERFORM, ADMINPH_ADD_ORDERFORM,
SUPPLIER_TENDER, PATIENT_SUBSCRIBE, FREE_D_APP, GRAFIC, RATE, RATE_P,
ACTIONS_AND_PROMOTIONS, ADD_ACTIONS_AND_PROMOTIONS, PRICELIST, VACATION, EDIT_PRICELIST, REPORT, REPORTM, REPORTQ,
MEDICAMENTS_LIST_PATH, ADMIN_REG_PATH, ADMIN_REG_DERM_PATH, ADMIN_REG_ADMIN_PATH, PATIENT_HOME_PATH, PATIENT_PROFILE_PATH,
PATIENT_PROFILE_PHARMACIES, EDIT_ORDER, ALL_D, ALL_P,
PATIENT_PROFILE_EXAMINATIONS, FREE_PHARMACIEST, SHOW_PHARMACY, SHOW_PH, ORDER_OFFERS,
PATIENT_PROFILE_EXAMINATIONS_PHARMACIEST, PATIENT_PROFILE_PRESCRIPTIONS, SHEDULED_EXAMINATIONS, RESERVED_MEDS, PATIENT_PENALS, PATIENT_E_MEDICINES, SUBSCRIBED_PHARMACIES, TAKE_MEDICINE, SCHEDULE_CONSULTATION, SCHEDULE_EXAMINATION, 
ADMINPH_HOME_PATH, ADMINPH_PROFILE_PATH, ADMINPH_MEDICATION_LIST, ADMINPH_PROFILEPAGE_PATH,
EDIT_ADMINPH_PROFILE, CHANGE_ADMINPH_PASSWORD,
 ADMIN_COMPLAINTS, FREE_DERM_APP,
  PATIENT_COMPLAINTS, MEDICAMENTS_PATH} from './config/router-paths';
  
import { AdminHomeComponent} from './components/adminhome/adminhome.component';
import {SupplierHomeComponent} from './components/supplierhome/supplierhome.component';
import {SupplierProfileComponent} from './components/supplierprofile/supplierprofile.component';
import { MedicamentsListComponent} from './components/medicamentslist/medicamentslist.component';
import { AdminRegComponent } from './components/adminreg/adminreg.component';
import { AdminRegDermComponent} from './components/adminregderm/adminregderm.component';
import { AdminAddComponent} from './components/adminhome/addadmin.component';
import { SupplierTenderComponent} from './components/suppliertender/suppliertender.component';
import { PatienthomeComponent } from './components/patienthome/patienthome.component';
import { PatientprofileComponent } from './components/patientprofile/patientprofile.component';
import { AllpharmaciesComponent } from './components/patientprofile/allpharmacies/allpharmacies.component';
import { ExaminationsComponent } from './components/patientprofile/examinations/examinations.component';
import { ExaminationsPharmComponent } from './components/patientProfile/examinations-pharm/examinations-pharm.component';
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { SheduledExaminationsComponent } from './components/patienthome/sheduled-examinations/sheduled-examinations.component';
import { ReservedMedsComponent } from './components/patienthome/reserved-meds/reserved-meds.component';
import { PenalsComponent } from './components/patienthome/penals/penals.component';
import { EMedsComponent } from './components/patienthome/e-meds/e-meds.component';
import { SubscribedPharmaciesComponent } from './components/patienthome/subscribed-pharmacies/subscribed-pharmacies.component';
import { TakeMedicineComponent } from './components/patienthome/take-medicine/take-medicine.component';
import { ScheduleConsultationsComponent } from './components/patienthome/schedule-consultations/schedule-consultations.component';
import { ScheduleExaminationsComponent } from './components/patienthome/schedule-examinations/schedule-examinations.component';
import { PharmacyAdminPageComponent } from './components/pharmacy-admin-page/pharmacy-admin-page.component';
import { PharmacyProfileComponent } from './components/pharmacy-admin-page/pharmacy-profile/pharmacy-profile.component';
import { MedicationListComponent } from './components/pharmacy-admin-page/medication-list/medication-list.component';
import { PharmacyAdminProfileComponent } from './components/pharmacy-admin-page/pharmacy-admin-profile/pharmacy-admin-profile.component';
import { Header2Component } from './components/header2/header2.component';
import { Header3Component } from './components/header3/header3.component';
import { EditPharmacyAdminComponent } from './components/pharmacy-admin-page/pharmacy-admin-profile/edit-pharmacy-admin/edit-pharmacy-admin.component';
import { ChangeAdminphPasswordComponent } from './components/pharmacy-admin-page/pharmacy-admin-profile/change-adminph-password/change-adminph-password.component';
import { ActionsAndPromotionsComponent } from './components/pharmacy-admin-page/actions-and-promotions/actions-and-promotions.component';
import { AddActionsAndPromotionsComponent } from './components/pharmacy-admin-page/actions-and-promotions/add-actions-and-promotions/add-actions-and-promotions.component';
import { PharmacyProfilePageComponent } from './components/pharmacy-profile-page/pharmacy-profile-page.component';
import { DermatologistComponent } from './components/pharmacy-admin-page/dermatologist/dermatologist.component';
import { PharmacistComponent } from './components/pharmacy-admin-page/pharmacist/pharmacist.component';
import { PharmacyPageComponent } from './components/pharmacy-admin-page/pharmacy-page/pharmacy-page.component';
import { PharmacysProfileComponent } from './components/pharmacy-admin-page/pharmacys-profile/pharmacys-profile.component';
import { OrderformComponent } from 'src/app/components/orderform/orderform.component';
import { AddOrderformComponent } from './components/orderform/add-orderform/add-orderform.component';
import { ComplaintsListComponent } from './components/adminhome/complaintslist.component';
import { PatientComplaintsComponent } from './components/patienthome/complaints/complaints.component';
import { PricelistComponent } from './components/pharmacy-admin-page/pricelist/pricelist.component';
import { AllpharmaciestComponent } from './components/patienthome/schedule-consultations/allpharmaciest/allpharmaciest.component';
import { MedicamentsComponent } from './components/medicaments/medicaments.component';
import { VacationRequestsComponent } from 'src/app/components/pharmacy-admin-page/vacation-requests/vacation-requests.component';
import { EditPricelistComponent } from 'src/app/components/pharmacy-admin-page/pricelist/edit-pricelist/edit-pricelist.component';
import { ShowPharmacyComponent } from 'src/app/components/pharmacy-admin-page/dermatologist/show-pharmacy/show-pharmacy.component';
import { ShowPHComponent } from 'src/app/components/pharmacy-admin-page/pharmacist/show-ph/show-ph.component';
import { OrderOffersComponent } from 'src/app/components/orderform/order-offers/order-offers.component';
import { EditOrderComponent } from 'src/app/components/orderform/edit-order/edit-order.component';
import { PatientSubscribeComponent } from 'src/app/components/pharmacy-profile-page/patient-subscribe/patient-subscribe.component';
import { DermAppointmentsComponent} from 'src/app/components/pharmacy-profile-page/derm-appointments/derm-appointments.component';
import { AllDermComponent } from 'src/app/components/pharmacy-admin-page/all-derm/all-derm.component';
import { AllPharmacistComponent } from 'src/app/components/pharmacy-admin-page/all-pharmacist/all-pharmacist.component';
import { FreeAppDermComponent } from 'src/app/components/pharmacy-admin-page/free-app-derm/free-app-derm.component';
import { GraphicsComponent } from 'src/app/components/pharmacy-admin-page/graphics/graphics.component';
import { ReportsComponent } from 'src/app/components/pharmacy-admin-page/reports/reports.component';
import { GraphicsMComponent } from 'src/app/components/pharmacy-admin-page/graphics-m/graphics-m.component';
import { GraphicsQComponent } from 'src/app/components/pharmacy-admin-page/graphics-q/graphics-q.component';
import { RateComponent } from 'src/app/components/pharmacy-profile-page/showing-dermatologists/rate/rate.component';
import { RatePComponent } from 'src/app/components/pharmacy-profile-page/showing-pharmacists/rate-p/rate-p.component';

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
    path: PHARMACY_HOMEPAGE,
    component: PharmacyProfilePageComponent
  },
  {
    path: PHARMACY_PAGE,
    component: PharmacyPageComponent
  },
  {
    path: PHARMACY_INFO,
    component: PharmacysProfileComponent
  },
  {
    path: RATE,
    component: RateComponent
  },
  {
    path: SHOW_PHARMACY,
    component: ShowPharmacyComponent
  },
  {
    path: REPORT,
    component:ReportsComponent
  },
  {
    path: RATE_P,
    component: RatePComponent
  },
  {
    path: REPORTM,
    component: GraphicsMComponent
  },
  {
    path: REPORTQ,
    component: GraphicsQComponent
  },
  {
    path: FREE_DERM_APP,
    component: DermAppointmentsComponent
  }, 
  {
    path: GRAFIC,
    component: GraphicsComponent
  },
  {
    path: PATIENT_SUBSCRIBE,
    component: PatientSubscribeComponent
  },
  {
    path: FREE_D_APP,
    component: FreeAppDermComponent
  },
  {
    path: HEADER1,
    component: Header2Component
  },
  {
    path: HEADER2,
    component: Header3Component
  },
  {
    path: DERMATOLOGIST,
    component: DermatologistComponent
  },
  {
    path: PHARMACIST,
    component: PharmacistComponent
  },
  {
    path: ACTIONS_AND_PROMOTIONS,
    component: ActionsAndPromotionsComponent
  },
  {
    path: ADD_ACTIONS_AND_PROMOTIONS,
    component: AddActionsAndPromotionsComponent
  },
  {
    path: PRICELIST,
    component: PricelistComponent
  },
  {
    path: EDIT_PRICELIST,
    component: EditPricelistComponent
  },
  {
    path: ALL_D,
    component: AllDermComponent
  },
  {
    path: ALL_P,
    component: AllPharmacistComponent
  },
  {
    path: ADMINPH_ORDERFORM,
    component: OrderformComponent
  },
  {
    path: ADMINPH_ADD_ORDERFORM,
    component: AddOrderformComponent
  },
  {
    path: ADMIN_HOME_PATH,
    component: AdminHomeComponent
  },
  {
    path: EDIT_ADMINPH_PROFILE,
    component: EditPharmacyAdminComponent
  },
  {
    path: EDIT_ORDER,
    component: EditOrderComponent
  },
  {
    path: CHANGE_ADMINPH_PASSWORD,
    component: ChangeAdminphPasswordComponent
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
    path: PATIENT_PROFILE_PRESCRIPTIONS,
    component: PrescriptionsComponent
  },
  {
    path: SHEDULED_EXAMINATIONS,
    component: SheduledExaminationsComponent
  },
  {
    path: RESERVED_MEDS,
    component: ReservedMedsComponent
  },
  {
    path: VACATION,
    component: VacationRequestsComponent
  },{
    path: SHOW_PH,
    component: ShowPHComponent
  },
  {
    path: ORDER_OFFERS,
    component: OrderOffersComponent
  },
  {
    path: PATIENT_PENALS,
    component: PenalsComponent
  },
  {
    path: PATIENT_E_MEDICINES,
    component: EMedsComponent
  },
  {
    path: MEDICAMENTS_LIST_PATH,
    component: MedicamentsListComponent
  },
  {
    path: SUBSCRIBED_PHARMACIES,
    component: SubscribedPharmaciesComponent
  },
  {
    path: TAKE_MEDICINE,
    component: TakeMedicineComponent
  },
  {
    path: SCHEDULE_CONSULTATION,
    component: ScheduleConsultationsComponent
  },
  {
    path: SCHEDULE_EXAMINATION,
    component: ScheduleExaminationsComponent
  },
  {
    path: FREE_PHARMACIEST,
    component: AllpharmaciestComponent
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
  {
    path: SUPPLIER_TENDER,
    component: SupplierTenderComponent
  },
  {
    path: ADMINPH_HOME_PATH,
    component: PharmacyAdminPageComponent
  },
  {
    path: ADMINPH_PROFILE_PATH,
    component: PharmacyProfileComponent
  },
  {
    path: ADMINPH_MEDICATION_LIST,
    component: MedicationListComponent
  },
  {
    path: ADMINPH_PROFILEPAGE_PATH,
    component: PharmacyAdminProfileComponent
  },
  {
    path: ADMIN_COMPLAINTS,
    component: ComplaintsListComponent
  },
  {
    path: PATIENT_COMPLAINTS,
    component: PatientComplaintsComponent
  },
  {
    path: MEDICAMENTS_PATH,
    component: MedicamentsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
