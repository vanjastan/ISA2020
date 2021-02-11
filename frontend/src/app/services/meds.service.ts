import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Meds } from '../components/medicamentslist/meds';
import { USER_ID_KEY } from '../config/local-storage-keys';
import { Medicine } from '../components/models/medicine';
import { MedicineReservation } from '../components/models/medicineReservation';


@Injectable({
    providedIn: 'root'
  })

  export class MedsService {
    constructor(private http: HttpClient) { 
    }
    
    getAllMeds(): Observable<any>{
        return this.http.get(`http://localhost:8080/api/meds/1`);
    }

    getMeds(): Observable<any>{
      return this.http.get(`http://localhost:8080/api/meds/{id}`);
    }    
    
    addMeds(meds: Meds): Observable<any> {
        return this.http.post(`http://localhost:8080/api/meds/add_meds`, meds);
    }

    public getResMedicines():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/api/meds/forPatient/${userId}`);
    }

    public cancelMed(id:number){
      return this.http.post(`http://localhost:8080/api/meds/cancel/`+ id, {});
    }

    getMedicinesWithEPrescriptions():Observable<any>{
      return this.http.get(`http://localhost:8080/api/meds/byPrescription`);
    }

    reserveMed(reservation:MedicineReservation, medicineId:number):Observable<any>{
      return this.http.post(`http://localhost:8080/reservations/addReservation/` + medicineId, reservation);
    }

    public addAllergy(id:number){
      return this.http.post(`http://localhost:8080/api/meds/addAllergy/`+ id, {});
    }

    public getAllMedicines(): Observable<any>{
      return this.http.get(`http://localhost:8080/api/meds/all`);
    }
  }