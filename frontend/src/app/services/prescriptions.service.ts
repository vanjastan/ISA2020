import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Prescription } from '../components/models/prescription';

@Injectable({
    providedIn: 'root'
  })
  export class PrescriptionsService {
  
    constructor(private http: HttpClient) { 
        this.getPrescriptions();
    }

    getPrescriptions():Observable<Prescription[]>{
        return this.http.get<Prescription[]>(`http://localhost:8080/prescriptions`);
    }
  }