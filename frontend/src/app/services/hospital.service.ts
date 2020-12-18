import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Hospital } from '../components/hospital/hospital';

@Injectable({
    providedIn: 'root'
  })

  export class HospitalService {
    constructor(private http: HttpClient) { 
    }
    
    addHospital(hosp: Hospital): Observable<any> {
        return this.http.post(`http://localhost:8080/api/hospitals/hospital/add_hospital`, hosp);
      }

  }