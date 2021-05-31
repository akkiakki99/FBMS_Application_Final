import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ParticipantComponent } from '../participant/participant.component';

@Injectable({
  providedIn: 'root'
})
export class ParticipantFeedbackService {

  feedApi : string;

  constructor(private httpClient : HttpClient) {
    this.feedApi = "http://localhost:8000/FeedbackProgram";
}

add(feedback : ParticipantComponent) : Observable<ParticipantComponent>{
  return this.httpClient.post<ParticipantComponent>(this.feedApi,feedback);
}
getAll() : Observable<ParticipantComponent[]>{
  return this.httpClient.get<ParticipantComponent[]>(this.feedApi);
}
}
