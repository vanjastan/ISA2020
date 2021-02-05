import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Complaints } from '../components/models/complaints';
import { USER_ID_KEY } from '../config/local-storage-keys';

@Injectable({
    providedIn: 'root'
  })
  export class ComplaintService {
  
    constructor(private http: HttpClient) { 
    }

    public getComplaints():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/complaints/forPatient/${userId}`);
    }

    saveComplaint(val:Complaints):Observable<any>{
      return this.http.post(`http://localhost:8080/complaints/addComplaint`, val);
    }

    public getAllComplaints(): Observable<any>{
      return this.http.get(`http://localhost:8080/complaintss/all`);
    }

  }