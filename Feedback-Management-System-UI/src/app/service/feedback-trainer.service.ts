import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { FeedbackTrainer } from '../model/feedback-trainer';

@Injectable({
  providedIn: 'root'
})
export class FeedbackTrainerService {
  ftsApi : string;
  private _currentFeedbackTrainer : FeedbackTrainer ;

  constructor(private httpClient : HttpClient) {
    this.ftsApi = "http://localhost:8000/FeedbackTrainer";
    this._currentFeedbackTrainer = null;
}
get currentFeedbackTrainer(){
  return this._currentFeedbackTrainer;
}


set currentFeedbackTrainer(cfps:FeedbackTrainer){
  this._currentFeedbackTrainer=cfps;
}


getAllbyTrainerId(tid : number) : Observable<FeedbackTrainer[]>{
  return this.httpClient.get<FeedbackTrainer[]>(`${this.ftsApi}/list/${tid}`);
}

getById(ftid : number ) : Observable<FeedbackTrainer> {
  return this.httpClient.get<FeedbackTrainer>(`${this.ftsApi}/${ftid}`);
 }

 add(feedbackt : FeedbackTrainer) : Observable<FeedbackTrainer>{
   return this.httpClient.post<FeedbackTrainer>(this.ftsApi,feedbackt);
 }

 update(feedbackt : FeedbackTrainer) : Observable<FeedbackTrainer>{
   return this.httpClient.put<FeedbackTrainer>(this.ftsApi,feedbackt);
 }
 getByProgramId(ftid : number ) : Observable<FeedbackTrainer[]> {
  return this.httpClient.get<FeedbackTrainer[]>(`${this.ftsApi}/list/${ftid}`);
 }

}

