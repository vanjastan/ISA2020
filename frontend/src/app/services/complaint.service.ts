import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Complaints } from '../components/models/complaints';

@Injectable({
    providedIn: 'root'
  })
  export class ComplaintService {
  
    constructor(private http: HttpClient) { 
    }

    getComplaints():Observable<Complaints[]>{
      return this.http.get<Complaints[]>(`http://localhost:8080/complaints`);
  }
  }