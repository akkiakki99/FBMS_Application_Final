import { Component, OnInit } from '@angular/core';
import { Program } from '../model/program';
import { ProgramService } from '../service/program.service';

@Component({
  selector: 'app-program-list',
  templateUrl: './program-list.component.html',
  styleUrls: ['./program-list.component.css']
})
export class ProgramListComponent implements OnInit {

  program : Program[];
  err : string;
  programId : any;
  p:number =1;
  
  constructor(private programService : ProgramService) { }
 
  ngOnInit(): void {
    this.programService.getAll().subscribe(
      (data) => this.program = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }
  SearchBox(){
    if(this.programId == ""){
      this.ngOnInit();
    }else{
      this.program = this.program.filter(res => {
        return res.programId.toString().match(this.programId.toString());
      });
    }
  
  }

  delete(programId : number) {
    if (confirm("Are you sure?")) {
      this.programService.removeProgram(programId).subscribe(
        () => { this.program.splice(this.program.findIndex(p => p.programId == programId), 1) }
      );
    }
  }
  key : string = "courseId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;

  }
}
