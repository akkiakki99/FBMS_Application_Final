import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Enrollment } from '../model/enrollment';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  enrollApi : string;

  constructor(private httpClient:HttpClient) { 
    this.enrollApi="http://localhost:8000/enroll";
  }

  addProgram(enroll : Enrollment):Observable<Enrollment>{
    return this.httpClient.post<Enrollment>(this.enrollApi,enroll);
  }

  getByEmployee(eid : number ) : Observable<Enrollment> {
    return this.httpClient.get<Enrollment>(`${this.enrollApi}/employee/${eid}`);
  
   } 
  getByProgram(pid : number ) : Observable<Enrollment> {
    return this.httpClient.get<Enrollment>(`${this.enrollApi}/program/${pid}`);
  
   } 
  }