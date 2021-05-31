import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Program } from '../model/program';
import { ProgramListComponent } from '../program-list/program-list.component';

@Injectable({
  providedIn: 'root'
})
export class ProgramService {
  private programApi: string;
  constructor(private httpClient: HttpClient) {
    this.programApi = "http://localhost:8000/program";
  }

  addProgram(program:Program):Observable<Program>{
    return this.httpClient.post<Program>(this.programApi,program);
  }

  getById(pid : number):Observable<Program>{
    return this.httpClient.get<Program>(`${this.programApi}/${pid}`);
  }  

  getAll() : Observable<Program[]> {
    return this.httpClient.get<Program[]>(this.programApi);
  }

  removeProgram(pid : number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.programApi}/${pid}`);
  }

  updateProgram(program : Program) : Observable<Program> {
    return this.httpClient.put<Program>(this.programApi, program);
  }

}
