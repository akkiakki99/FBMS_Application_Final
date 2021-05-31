import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private courseApi:string;
  
  constructor(private httpClient:HttpClient) {
    this.courseApi="http://localhost:8000/course";
  }

  getAll():Observable<Course[]>{
    return this.httpClient.get<Course[]>(this.courseApi);
  }

  getById(cid:number):Observable<Course>{
    return this.httpClient.get<Course>(`${this.courseApi}/${cid}`);
  }

  addCourse(course : Course):Observable<Course>{
    console.log(course);
    return this.httpClient.post<Course>(this.courseApi,course);
  }

  updateCourse(course : Course):Observable<Course>{
    return this.httpClient.put<Course>(this.courseApi,course);
  }

  removeCourse(cid : number) : Observable<void> {
    return this.httpClient.delete<void>(`${this.courseApi}/${cid}`);
  }
}
