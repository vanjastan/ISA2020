import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pharmacies } from '../components/models/pharmacies';
import { USER_ID_KEY } from '../config/local-storage-keys';
import { User } from '../components/models/user';
import { identifierModuleUrl } from '@angular/compiler';
import { Medicine } from '../components/models/medicine';
import { Vacation } from '../components/models/vacation';
import { PriceList } from '../components/models/pricelist';


@Injectable({
    providedIn: 'root'
 })
 
  export class PharmaciesService {
  
    constructor(private http: HttpClient) { 
        this.getPharmacies();
    }

    public getPharmacies():Observable<any>{
        return this.http.get(`http://localhost:8080/pharmacies`);
    }

    public getPharmacyInfo(): Observable<any> {
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/pharmacies/logged/${userId}`);
    }

    public getBenuInfo(id:number): Observable<any> {
     // const userId = localStorage.getItem(PH_ID_KEY);
      return this.http.get(`http://localhost:8080/pharmacies/${id}` );
    }

    public getPhInfo(): Observable<any> {
      return this.http.get(`http://localhost:8080/pharmacies/1`);
    }

    public getBenu2Info(): Observable<any> {
      return this.http.get(`http://localhost:8080/pharmacies/2`);
    }

    public getUserInfo(): Observable<any> {
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/api/users/logged/${userId}`);
    }

    editPharmacy(pharmacies: Pharmacies) : Observable<Pharmacies> {
      return  this.http.put<Pharmacies>(`http://localhost:8080/api/users/edit`, pharmacies);
    }

    editUsers(user: User) : Observable<User> {
      return  this.http.put<User>(`http://localhost:8080/api/users/edit`, user);
    }

    public getDermatologist():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/dermatologist/1`);
    }

    public getDermatologistt():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/dermatologist/2`);
    }

    public getPharmacist():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/pharmacist/1`);
    }

    public getPharmacistt():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/pharmacist/2`);
    }

    public getPatientSubscribedPharmacies():Observable<any>{
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/pharmacies/subscribed/${userId}`);
    }

    public getPharmaciesByMedicineId(id: number):Observable<Pharmacies[]>{
      return this.http.get<Pharmacies[]>(`http://localhost:8080/pharmacies/medicine/`+id);
    }

    public getFreePharmaciest():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/1/pharmacist`);
    }

    public getPriceList():Observable<any>{
      return this.http.get(`http://localhost:8080/pricelist/all`);
    }
    
    public getPrice():Observable<any>{
      return this.http.get(`http://localhost:8080/pricelist/1`);
    }

    public getVacations():Observable<any>{
      return this.http.get(`http://localhost:8080/vacation/request`);
    }

    public confirmVacation(id:number): Observable<any> {
      return this.http.post(`http://localhost:8080/vacation/holidays/` + id, {});
    }

    public refuseVacation(id:number): Observable<any> {
      return this.http.post(`http://localhost:8080/vacation/noholidays/` + id, {});
    }

    editPricelist(pricelist: PriceList): Observable<PriceList> {
      return this.http.post<PriceList>(`http://localhost:8080/pricelist/editPricelist`, pricelist);
    }

    public getPh(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/api/users/pharmacy/` + id, {}); // {dermatologistId}
    }

    public getPhamr(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/api/users/ph/`+id, {}); //{pharmacist_id}
    }


    public getDerma(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/dermatologist/` + id, {});
    }

    public getPharmaciests(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/pharmacist/` + id, {});
    }

    public getMeds(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/api/meds/` + id, {});
    }

    public getRate(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/ratingd/` + id, {});
    }

    public getRateP(id:number):Observable<any>{
      return this.http.get(`http://localhost:8080/rating/` + id, {});
    }

    public getAllD():Observable<any>{
      return this.http.get(`http://localhost:8080/api/users/derm/all`);
    }

    public getAllP():Observable<any>{
      return this.http.get(`http://localhost:8080/api/users/ph/all`);
    }
  
  }