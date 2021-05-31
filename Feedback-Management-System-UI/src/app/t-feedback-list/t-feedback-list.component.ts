import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/employee';
import { FeedbackTrainer } from '../model/feedback-trainer';
import { EmployeeService } from '../service/employee.service';
import { FeedbackTrainerService } from '../service/feedback-trainer.service';

@Component({
  selector: 'app-t-feedback-list',
  templateUrl: './t-feedback-list.component.html',
  styleUrls: ['./t-feedback-list.component.css']
})
export class TFeedbackListComponent implements OnInit {
  err : string;
  ft : FeedbackTrainer[];
  infoMsg : string;
  employee : Employee[];
  ftp : FeedbackTrainer;

  constructor(private ftService : FeedbackTrainerService, private activatedRoute: ActivatedRoute, private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.getByRole("Coordinator").subscribe(
      (data) => this.employee = data
    );
  }
}
