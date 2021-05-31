import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ParticipantComponent } from '../participant/participant.component';

@Injectable({
  providedIn: 'root'
})
export class TrainerListService {
  
  feedsApi : string;

  constructor(private httpClient : HttpClient) {
    this.feedsApi = "http://localhost:8000/FeedbackTrainer";
}

add(feedback : ParticipantComponent) : Observable<ParticipantComponent>{
  return this.httpClient.post<ParticipantComponent>(this.feedsApi,feedback);
}
getAll() : Observable<ParticipantComponent[]>{
  return this.httpClient.get<ParticipantComponent[]>(this.feedsApi);
}


getById(ftid : number ) : Observable<ParticipantComponent[]> {
  return this.httpClient.get<ParticipantComponent[]>(`${this.feedsApi}/${ftid}`);

}
}
