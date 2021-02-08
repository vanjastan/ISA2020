import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Pharmacies } from '../components/models/pharmacies';
import { USER_ID_KEY , PH_ID_KEY} from '../config/local-storage-keys';
import { User } from '../components/models/user';
import { identifierModuleUrl } from '@angular/compiler';
import { Medicine } from '../components/models/medicine';



@Injectable({
    providedIn: 'root'
  })
  export class PharmaciesService {
  
    constructor(private http: HttpClient) { 
        this.getPharmacies();
    }

    getPharmacies():Observable<Pharmacies[]>{
        return this.http.get<Pharmacies[]>(`http://localhost:8080/pharmacies`);
    }

    public getPharmacyInfo(): Observable<any> {
      const userId = localStorage.getItem(USER_ID_KEY);
      return this.http.get(`http://localhost:8080/pharmacies/logged/${userId}`);
    }

    public getBenuInfo(id:number): Observable<any> {
     // const userId = localStorage.getItem(PH_ID_KEY);
      return this.http.get(`http://localhost:8080/pharmacies/${id}` );
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
      return this.http.get(`http://localhost:8080/pharmacies/1/dermatologist`);
    }

    public getDermatologistt():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/2/dermatologist`);
    }

    public getPharmacist():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/1/pharmacist`);
    }

    public getPharmacistt():Observable<any>{
      return this.http.get(`http://localhost:8080/pharmacies/2/pharmacist`);
    }

    public getPatientSubscribedPharmacies(){

    }

    public getPharmaciesByMedicineId(id: number):Observable<Pharmacies[]>{
      return this.http.get<Pharmacies[]>(`http://localhost:8080/pharmacies/medicine/`+id);
    }

    public getPriceList():Observable<any>{
      return this.http.get(`http://localhost:8080/pricelist/all`);
    }

  }