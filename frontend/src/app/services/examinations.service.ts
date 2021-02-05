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

    public getFreeExaminations():Observable<any>{
      return this.http.get(`http://localhost:8080/examinations/freeExaminations`);
    }

    public getExaminationsPharm():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/examinationsPh/forPatient/${userId}`);
    }

    schedule(val:Examinations):Observable<any>{
      return this.http.post(`http://localhost:8080/examinations/reserve`, val);
    }

    public getScheduledEx():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/examinations/scheduled/${userId}`);
    }

    public getScheduledCons():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/examinationsPh/scheduled/${userId}`);
    }

    public unscheduleExamination(id:number){
      return this.http.post(`http://localhost:8080/examinations/unsubscribe/`+ id, {});
    }

    public unscheduleConsultation(id:number){
      return this.http.post(`http://localhost:8080/examinationsPh/unsubscribe/`+ id, {});
    }
  }