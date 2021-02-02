import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActionsAndPromotions } from 'src/app/components/models/actions';

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

    saveActions(val:ActionsAndPromotions):Observable<any>{
      return this.http.post(`http://localhost:8080/actions/addActionPromotion`, val);
    }
  }