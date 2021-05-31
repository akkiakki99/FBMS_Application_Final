import { Component, ErrorHandler, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../model/course';
import { Employee } from '../model/employee';
import { CourseService } from '../service/course.service';
import { EmployeeService } from '../service/employee.service';
import { ProgramService } from '../service/program.service';

@Component({
  selector: 'app-program-form',
  templateUrl: './program-form.component.html',
  styleUrls: ['./program-form.component.css']
})
export class ProgramFormComponent implements OnInit {

  programIdfc :FormControl;
  startDatefc : FormControl;
  endDatefc : FormControl;
  coursefc : FormControl;
  trainerfc : FormControl;

  programForm : FormGroup;
  isEditing : boolean;
  course : Course[];
  emp : Employee;
  infoMsg : string;
  // emp : Employee;
 
  constructor(private programService : ProgramService, private router : Router,
    private activatedRoute : ActivatedRoute, private courseService : CourseService, private employeeService : EmployeeService) {
    this.programIdfc = new FormControl('0');
    this.startDatefc = new FormControl(null, [Validators.required]);
    this.endDatefc = new FormControl(null, [Validators.required]);
    this.coursefc = new FormControl(null, [Validators.required]);
    this.trainerfc = new FormControl(null, [Validators.required]);

    this.isEditing = false;

    this.programForm = new FormGroup(
      {programId : this.programIdfc,
       startDate : this.startDatefc,
       endDate : this.endDatefc,
       course : this.coursefc,
       trainer : this.trainerfc
      }
       );
     }

  ngOnInit(): void {
    let pid = this.activatedRoute.snapshot.params.pid;
    if (pid) {
      this.isEditing = true;
      this.programService.getById(pid).subscribe(
        (data) => this.programForm.setValue(data)
      );
    }
    this.courseService.getAll().subscribe(
      (data) => this.course = data);

      this.emp=this.employeeService.currentEmployee;
      this.activatedRoute.queryParams.subscribe(
        (params)=>{
          if(params.msg){
            this.infoMsg=params.msg;
            this.emp=this.employeeService.currentEmployee;
            console.log(this.emp);
          }
        }
      );
    }

  
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.programService.updateProgram(this.programForm.value);
    } else {
      obr = this.programService.addProgram(this.programForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/coordinator/program/list")
    );
  }
}
