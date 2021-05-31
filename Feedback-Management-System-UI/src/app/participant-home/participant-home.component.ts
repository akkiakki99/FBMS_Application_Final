import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-participant-home',
  templateUrl: './participant-home.component.html',
  styleUrls: ['./participant-home.component.css']
})
export class ParticipantHomeComponent implements OnInit {

  employee:Employee;
  infoMsg:string;

  constructor(
    private employeeService:EmployeeService,
    private activatedRoute:ActivatedRoute
    ) { }

  ngOnInit() {
    this.employee=this.employeeService.currentEmployee;

    this.activatedRoute.queryParams.subscribe(
      (params)=>{
        if(params.msg){
          this.infoMsg=params.msg;
          this.employee=this.employeeService.currentEmployee;
          console.log(this.employee);
        }
      }
    );
  }

}
