import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { FeedbackTrainerService } from '../service/feedback-trainer.service';

@Component({
  selector: 'app-feedback-trainer-form',
  templateUrl: './feedback-trainer-form.component.html',
  styleUrls: ['./feedback-trainer-form.component.css']
})
export class FeedbackTrainerFormComponent implements OnInit {
  alert:boolean = false
  fdtrainerIdfc : FormControl; 
	technicalskillsfc: FormControl;
	clarityofspeechfc: FormControl;
	communicationalskillsfc: FormControl;
	friendlinessfc: FormControl;
	overallratingfc: FormControl;
	commentsfc : FormControl;
	suggestionsfc : FormControl;
  feedbackForm: FormGroup;
  isEditing : boolean;
  infoMsg : boolean;
  
  trainerfc : FormControl;
  emp : Employee[];

  tech : string[];
  cos : string[];
  comm : string[];
  frnd : string[];
  oall : string[];

  constructor(private ftService : FeedbackTrainerService,private employeeService : EmployeeService, private router : Router, private activatedRoute : ActivatedRoute) {
    this.fdtrainerIdfc = new FormControl('0');
    this.technicalskillsfc = new FormControl(null);
    this.clarityofspeechfc= new FormControl(null);
    this.communicationalskillsfc = new FormControl(null);
    this.friendlinessfc= new FormControl(null);
    this.overallratingfc= new FormControl(null);
    this.commentsfc = new FormControl(null, Validators.required); 
    this.suggestionsfc = new FormControl(null, Validators.required); 
    this.trainerfc =  new FormControl(null);
  
    this.isEditing = false;
    this.infoMsg = false;

    this.feedbackForm = new FormGroup({
      fdtrainerId : this.fdtrainerIdfc,
      technicalskills : this.technicalskillsfc,
      clarityofspeech : this.clarityofspeechfc,
      communicationalskills : this.communicationalskillsfc,
      friendliness : this.friendlinessfc,
      overallrating : this.overallratingfc,
      comments : this.commentsfc,
      suggestions : this.suggestionsfc,
      trainer : this.trainerfc
    });

    this.tech = ["0","1","2","3","4","5"]
    this.cos = ["0","1","2","3","4","5"]
    this.comm = ["0","1","2","3","4","5"]
    this.frnd = ["0","1","2","3","4","5"]
    this.oall = ["0","1","2","3","4","5"]
    
  }
  ngOnInit() : void {
    let fdtrainerId = this.activatedRoute.snapshot.params.fdtrainerId;
    if (fdtrainerId) {
      this.isEditing = true;
      this.ftService.getById(fdtrainerId).subscribe(
        (data) => this.feedbackForm.setValue(data)
      );
    }
    this.employeeService.getByRole("Coordinator").subscribe(
      (data) => this.emp = data
    );
    }
    
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
    obr = this.ftService.update(this.feedbackForm.value);
   } else {
     console.log(this.feedbackForm.value);
     this.infoMsg = true;
    obr = this.ftService.add(this.feedbackForm.value);
   }
    obr.subscribe(
      // (data) => { this.ftService.currentFeedbackTrainer = data
        // this.router.navigateByUrl("/participant/homeparticipant")},
        this.feedbackForm.reset()
    );
    this.alert = true
  }
  closeAlert(){
    this.alert = false
  }
}
