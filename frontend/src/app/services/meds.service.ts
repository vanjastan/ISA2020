import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Meds } from '../components/medicamentslist/meds';
import { USER_ID_KEY } from '../config/local-storage-keys';
import { Medicine } from '../components/models/medicine';


@Injectable({
    providedIn: 'root'
  })

  export class MedsService {
    constructor(private http: HttpClient) { 
    }
    
    getAllMeds(): Observable<any>{
        return this.http.get(`http://localhost:8080/api/meds/all`);
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
      const userId = localStorage.getItem(USER_ID_KEY);
      //SREDI PUTANJU
      return this.http.get(`http://localhost:8080/api/meds/forPatient/${userId}`);
    }

    public reserveMed(id:number):Observable<Medicine>{
      return this.http.post<Medicine>(`http://localhost:8080/api/meds/reserveMed/` + id, {});
    }

    public addAllergy(id:number){
      return this.http.post(`http://localhost:8080/api/meds/addAllergy/`+ id, {});
    }
  }