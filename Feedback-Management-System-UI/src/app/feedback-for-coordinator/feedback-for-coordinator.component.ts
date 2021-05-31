import { Component, OnInit } from '@angular/core';
import { ParticipantComponent } from '../participant/participant.component';
import { ParticipantFeedbackService } from '../service/participant-feedback.service';

@Component({
  selector: 'app-feedback-for-coordinator',
  templateUrl: './feedback-for-coordinator.component.html',
  styleUrls: ['./feedback-for-coordinator.component.css']
})
export class FeedbackForCoordinatorComponent implements OnInit {

  feedback : ParticipantComponent[];
  err : string;
  
  
  constructor(private feedService : ParticipantFeedbackService) { }
 
  ngOnInit(): void {
    this.feedService.getAll().subscribe(
      (data) => this.feedback = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }
}