import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { USER_ID_KEY } from '../config/local-storage-keys';

@Injectable({
    providedIn: 'root'
})

    export class LoyaltyProgramService {
        constructor(private http: HttpClient) { 
    }

    public getProgram(): Observable<any> {
        const userId = localStorage.getItem(USER_ID_KEY);
        return this.http.get(`http://localhost:8080/loyalty/forPatient/${userId}`);
    }
}