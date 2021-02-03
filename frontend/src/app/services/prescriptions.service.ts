import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prescription } from '../components/models/prescription';
import { USER_ID_KEY } from '../config/local-storage-keys';

@Injectable({
    providedIn: 'root'
  })
  export class PrescriptionsService {
  
    constructor(private http: HttpClient) { 
    }

    getPrescriptions():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get<Prescription[]>(`http://localhost:8080/prescriptions/forPatient/${userId}`);
    }
  }