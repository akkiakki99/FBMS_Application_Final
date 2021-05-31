import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-coordinator-home',
  templateUrl: './coordinator-home.component.html',
  styleUrls: ['./coordinator-home.component.css']
})
export class CoordinatorHomeComponent implements OnInit {

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
