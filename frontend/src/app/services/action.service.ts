import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
    providedIn: 'root'
  })

  export class ActionService {
    constructor(private http: HttpClient) { 
      this.getAllActions();
    }
    
    getAllActions(): Observable<any> {
        return this.http.get(`http://localhost:8080/actions/all`);
    }
  }