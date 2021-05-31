import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FeedbackProgram } from '../model/feedback-program';

@Injectable({
  providedIn: 'root'
})
export class FeedbackProgramService {
  fpsApi : string;
  private _currentFeedbackProgram : FeedbackProgram ;

  constructor(private httpClient : HttpClient) {
    this.fpsApi = "http://localhost:8000/FeedbackProgram";
    this._currentFeedbackProgram = null;
}
get currentFeedbackProgram(){
  return this._currentFeedbackProgram;
}


set currentFeedbackProgram(cfps:FeedbackProgram){
  this._currentFeedbackProgram=cfps;
}


getAllbyProgramId(pid : number) : Observable<FeedbackProgram[]>{
  return this.httpClient.get<FeedbackProgram[]>(`${this.fpsApi}/list/${pid}`);
}

getById(fpid : number ) : Observable<FeedbackProgram> {
  return this.httpClient.get<FeedbackProgram>(`${this.fpsApi}/${fpid}`);
 }

 add(feedbackp : FeedbackProgram) : Observable<FeedbackProgram>{
   return this.httpClient.post<FeedbackProgram>(this.fpsApi,feedbackp);
 }

 update(feedbackp : FeedbackProgram) : Observable<FeedbackProgram>{
   return this.httpClient.put<FeedbackProgram>(this.fpsApi,feedbackp);
 }

 getByProgramId(fpid : number ) : Observable<FeedbackProgram[]> {
  return this.httpClient.get<FeedbackProgram[]>(`${this.fpsApi}/list/${fpid}`);
 }


}