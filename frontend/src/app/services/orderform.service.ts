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

    editOrder(orders: OrderForm): Observable<OrderForm> {
      return this.http.post<OrderForm>(`http://localhost:8080/orderform/editOrder`, orders);
    }

    
    deleteOF(id:number):Observable<any>{
      return this.http.delete(`http://localhost:8080/orderform/` + id, {});
    }

    chooseOF(id:number):Observable<any>{
      return this.http.post(`http://localhost:8080/ofers/choosen/` + id, {});
    }
  }