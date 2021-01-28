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

    getPharmacies():Observable<Pharmacies[]>{
        return this.http.get<Pharmacies[]>(`http://localhost:8080/pharmacies`);
    }
  }