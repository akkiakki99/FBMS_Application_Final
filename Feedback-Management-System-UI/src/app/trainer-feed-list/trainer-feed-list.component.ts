import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { FeedbackTrainer } from '../model/feedback-trainer';
import { EmployeeService } from '../service/employee.service';
import { FeedbackTrainerService } from '../service/feedback-trainer.service';

@Component({
  selector: 'app-trainer-feed-list',
  templateUrl: './trainer-feed-list.component.html',
  styleUrls: ['./trainer-feed-list.component.css']
})
export class TrainerFeedListComponent implements OnInit {

  feedback : FeedbackTrainer[];
  err : string;
  employee : Employee[];
  trainerid : number;

  constructor(private feedService : FeedbackTrainerService, private employeeService : EmployeeService) {
    this.trainerid = null;
   }
 
  ngOnInit(): void {
    this.employeeService.getByRole("Coordinator").subscribe(
      (data) => this.employee = data
    );
}

handleSubmit() : void{
  console.log(this.trainerid);
  this.feedService.getAllbyTrainerId(this.trainerid).subscribe(
    (data) => this.feedback = data
  );
}

}
