import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActionsAndPromotions } from 'src/app/components/models/actions';
import { Subscribe } from '../components/models/subscribe';
import { OrderForm } from '../components/models/orderform';

@Injectable({
    providedIn: 'root'
  })

  export class OrderFormService {
    constructor(private http: HttpClient) { 
     
    }
    
    getAllOF(): Observable<any> {
        return this.http.get(`http://localhost:8080/orderform`);
    }

    getAllOffer(): Observable<any> {
      return this.http.get(`http://localhost:8080/ofers/all`);
  }

    saveOrderForm(val:OrderForm):Observable<any>{
      return this.http.post(`http://localhost:8080/orderform/add`, val);
    }
  }