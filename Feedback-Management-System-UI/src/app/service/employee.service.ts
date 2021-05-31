import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  empsApi : string;
  private _currentEmployee : Employee;

  constructor(private httpClient : HttpClient) {
    this.empsApi = "http://localhost:8000/admin";
    this._currentEmployee = null;
}
get currentEmployee(){
  return this._currentEmployee;
}


set currentEmployee(cs:Employee){
  this._currentEmployee=cs;
}


getAll() : Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(this.empsApi);
}

getById(eid : number ) : Observable<Employee> {
  return this.httpClient.get<Employee>(`${this.empsApi}/${eid}`);

 } 
 getBySkill(eskills : string ) : Observable<Employee> {
  return this.httpClient.get<Employee>(`${this.empsApi}/${eskills}`);

 } 

 deleteById(eid : number) : Observable<void>{
   return this.httpClient.delete<void>(`${this.empsApi}/${eid}`);
 }

 add(employee : Employee) : Observable<Employee>{
   return this.httpClient.post<Employee>(this.empsApi,employee);
 }

 update(employee : Employee) : Observable<Employee>{
   return this.httpClient.put<Employee>(this.empsApi,employee);
 }

getByRole(erole : string) : Observable<Employee[]>{
  return this.httpClient.get<Employee[]>(`${this.empsApi}/role/${erole}`);
}


}
