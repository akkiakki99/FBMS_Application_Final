import { Component, OnInit } from '@angular/core';
import { FeedbackProgram } from '../model/feedback-program';
import { Program } from '../model/program';
import { FeedbackProgramService } from '../service/feedback-program.service';
import { ProgramService } from '../service/program.service';

@Component({
  selector: 'app-prog-feed-list',
  templateUrl: './prog-feed-list.component.html',
  styleUrls: ['./prog-feed-list.component.css']
})
export class ProgFeedListComponent implements OnInit {

  feedback : FeedbackProgram[];
  err : string;
  program : Program[];
  programid : number;
  
  constructor(private feedService : FeedbackProgramService, private programService : ProgramService) { 
    this.programid = null;
  }
 
  ngOnInit(): void {
    this.programService.getAll().subscribe(
      (data) => this.program = data,
    );
  }

  handleSubmit() : void{
    console.log(this.programid);
    this.feedService.getAllbyProgramId(this.programid).subscribe(
      (data) => this.feedback = data
    );
  }
}
