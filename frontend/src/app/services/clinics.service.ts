import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
  })

  export class ClinicsService {
    constructor(private http: HttpClient) { 
    }
    
    getAllClinics(): Observable<any> {
      return this.http.get(`http://localhost:8080/api/clinics/clinics/all`);
    }
  }