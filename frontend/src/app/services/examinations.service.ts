import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Examinations } from '../components/models/examination';
import { USER_ID_KEY } from '../config/local-storage-keys';

@Injectable({
    providedIn: 'root'
  })
  export class ExaminationsService {
  
    constructor(private http: HttpClient) { 
        this.getExaminations();
        this.getExaminationsPharm();
    }

    public getExaminations():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/examinations/forPatient/${userId}`);
    }

    public getExaminationsPharm():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/examinationsPh/forPatient/${userId}`);
    }

    schedule(val:Examinations):Observable<any>{
      return this.http.post(`http://localhost:8080/examinations/reserve`, val);
    }
  }