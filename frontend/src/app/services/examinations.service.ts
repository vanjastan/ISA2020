import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Examinations } from '../components/models/examination';

@Injectable({
    providedIn: 'root'
  })
  export class ExaminationsService {
  
    constructor(private http: HttpClient) { 
        this.getExaminations();
        this.getExaminationsPharm();
    }

    getExaminations():Observable<any>{
        return this.http.get(`http://localhost:8080/examinations`);
    }

    getExaminationsPharm():Observable<any>{
      return this.http.get(`http://localhost:8080/examinationsPh`);
    }

    schedule(val:Examinations):Observable<any>{
      return this.http.post(`http://localhost:8080/examinations/reserve`, val);
    }
  }