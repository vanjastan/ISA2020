import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

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
  }