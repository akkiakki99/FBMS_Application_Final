import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Program } from '../model/program';
import { FeedbackProgramService } from '../service/feedback-program.service';
import { ProgramService } from '../service/program.service';

@Component({
  selector: 'app-feedback-program-form',
  templateUrl: './feedback-program-form.component.html',
  styleUrls: ['./feedback-program-form.component.css']
})
export class FeedbackProgramFormComponent implements OnInit {

  alert:boolean = false
  fdprogramIdfc : FormControl; 
	clarityfc: FormControl;
	technicalityfc: FormControl;
	realworldappfc: FormControl;
	interestingfc: FormControl;
	overallratingfc: FormControl;
	commentsfc : FormControl;
	suggestionsfc : FormControl;
  feedbackForm: FormGroup;
  isEditing : boolean;
  infoMsg : boolean;
  
  programfc : FormControl;
  program : Program[];

  clarity : string[];
  tech : string[];
  rwa : string[];
  interest : string[];
  oall : string[];

  constructor(private fpService : FeedbackProgramService,private programService :ProgramService, private router : Router, private activatedRoute : ActivatedRoute) {
    this.fdprogramIdfc = new FormControl('0');
    this.clarityfc = new FormControl(null);
    this.technicalityfc= new FormControl(null);
    this.realworldappfc = new FormControl(null);
    this.interestingfc= new FormControl(null);
    this.overallratingfc= new FormControl(null);
    this.commentsfc = new FormControl(null, Validators.required); 
    this.suggestionsfc = new FormControl(null, Validators.required); 
    this.programfc =  new FormControl(null);
  
    this.isEditing = false;
    this.infoMsg = false;

    this.feedbackForm = new FormGroup({
      fdprogramId : this.fdprogramIdfc,
      clarity : this.clarityfc,
      technicality : this.technicalityfc,
      realworldapp : this.realworldappfc,
      interesting : this.interestingfc,
      overallrating : this.overallratingfc,
      comments : this.commentsfc,
      suggestions : this.suggestionsfc,
      program : this.programfc
    });

    this.clarity = ["0","1","2","3","4","5"]
    this.tech = ["0","1","2","3","4","5"]
    this.rwa = ["0","1","2","3","4","5"]
    this.interest = ["0","1","2","3","4","5"]
    this.oall = ["0","1","2","3","4","5"]
    
    
  }
  ngOnInit() : void {
    let fdprogramId = this.activatedRoute.snapshot.params.fdprogramId;
    if (fdprogramId) {
      this.isEditing = true;
      this.fpService.getById(fdprogramId).subscribe(
        (data) => this.feedbackForm.setValue(data)
      );
    }
    this.programService.getAll().subscribe(
      (data) => this.program = data);
    }
    
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
    obr = this.fpService.update(this.feedbackForm.value);
   } else {
     console.log(this.feedbackForm.value);
     this.infoMsg = true;
    obr = this.fpService.add(this.feedbackForm.value);
   }
    obr.subscribe(
      // (data) => {this.router.navigateByUrl("/participant/homeparticipant")},
      this.feedbackForm.reset()
      );
      this.alert = true
    }
    closeAlert(){
      this.alert = false
    }

}
