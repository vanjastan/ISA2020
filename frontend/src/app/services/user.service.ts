import { VERIFY_ACC_URL, REGISTER_URL } from './../config/api-paths';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import UserRegistrationDTO from '../components/models/user-registration-dto.model';


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

}
