import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pharmacies } from '../components/models/pharmacies';

@Injectable({
    providedIn: 'root'
  })
  export class PharmaciesService {
  
    constructor(private http: HttpClient) { 
        this.getPharmacies();
    }

    getPharmacies():Observable<any>{
        return this.http.get(`http://localhost:8080/pharmacies`);
    }
  }