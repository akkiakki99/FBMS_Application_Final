import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginList : Login[] = [];

  constructor(private httpClient : HttpClient) {}

    getEmployee(login : Login){
      console.log(login);
      return this.httpClient.post<Employee>("http://localhost:8000/login/validate",login);
    }
}
