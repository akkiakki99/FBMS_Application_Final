import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../model/employee';
import { Program } from '../model/program';
import { EmployeeService } from '../service/employee.service';
import { EnrollmentService } from '../service/enrollment.service';
import { ProgramService } from '../service/program.service';

@Component({
  selector: 'app-program-enroll-form',
  templateUrl: './program-enroll-form.component.html',
  styleUrls: ['./program-enroll-form.component.css']
})
export class ProgramEnrollFormComponent implements OnInit {
   
  idfc : FormControl;
  employeefc: FormControl;
  programfc : FormControl;

  enrollForm : FormGroup;
  program : Program[];
  employee : Employee[];

  constructor(private enrollService : EnrollmentService, private router : Router,
    private activatedRoute : ActivatedRoute,private programService : ProgramService,private employeeService : EmployeeService) {
      this.idfc = new FormControl('0');
      this.employeefc = new FormControl(null, [Validators.required]);
      this.programfc = new FormControl(null, [Validators.required]);

      this.enrollForm = new FormGroup({
        id : this.idfc,
        employee : this.employeefc,
        program : this.programfc
      });
     }

  ngOnInit(): void {
    this.programService.getAll().subscribe(
      (data) => this.program = data);

    this.employeeService.getByRole("Participant").subscribe(
      (data) => this.employee = data
    );
  }

  handleSubmit() {
    let obr = null;
    obr = this.enrollService.addProgram(this.enrollForm.value);
    obr.subscribe(
      (data) => this.router.navigateByUrl("/coordinator/coordinatorhome")
    );
  }

}
