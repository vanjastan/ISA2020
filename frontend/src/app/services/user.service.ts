import { VERIFY_ACC_URL, REGISTER_URL } from './../config/api-paths';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import UserRegistrationDTO from '../components/models/user-registration-dto.model';
import { Supplier } from '../components/adminreg/supplier';
import { USER_ID_KEY } from '../config/local-storage-keys';
import { User } from '../components/models/user';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { 
  }

  verifyAccount(token: string): Observable<any> {
    return this.http.get(`${VERIFY_ACC_URL}/${token}`);
  }

  register(user: UserRegistrationDTO): Observable<any> {
    return this.http.post(REGISTER_URL, user);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(`http://localhost:8080/api/users/user/all`);
  }

  getUser(userId: number): Observable<any> {
    return this.http.get(`http://localhost:8080/api/users/logged/${userId}`);
  }

  registerSup(user: UserRegistrationDTO): Observable<any> {
    return this.http.post(`http://localhost:8080/api/users/registersup`, user);
  }

  registerDerm(user: UserRegistrationDTO): Observable<any> {
    return this.http.post(`http://localhost:8080/api/users/registerderm`, user);
  }
  
  registerAdmin(user: UserRegistrationDTO): Observable<any> {
    return this.http.post(`http://localhost:8080/api/users/registeradmin`, user);
  }

  public getUserInfo(): Observable<any> {
    const userId = localStorage.getItem(USER_ID_KEY);
    return this.http.get(`http://localhost:8080/api/users/logged/${userId}`);
  }

  editUsers(user: User) : Observable<User> {
    return  this.http.put<User>(`http://localhost:8080/api/users/edit/patient`, user);
  }

  setNewPass(user: User): Observable<User>{
    return this.http.post<User>(`http://localhost:8080/api/users/editPass`, user)
  }
}
