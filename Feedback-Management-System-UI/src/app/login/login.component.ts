import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../model/employee';
import { Login } from '../model/login';
import { EmployeeService } from '../service/employee.service';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login : Login; 
  employee : Employee;
  id : String;

  constructor(private route: Router, private loginservice: LoginService, private employeeService : EmployeeService) { 
    this.login = {
      employeeName : null,
      employeePassword : null
    }
  }

  ngOnInit(): void {
  }

  checkRole(emp : Employee){
    
    if(emp==null){
      alert("Invalid Username and Password");
    }
    
    if(emp.employeeRole=="Admin"){
      this.route.navigate(['admin']);
    }else if(emp.employeeRole=="Coordinator"){
      this.route.navigate(['coordinator']);
    }else if(emp.employeeRole=="Participant"){
      this.route.navigate(['participant']);
    }else{
      alert("You are not registered!")
    }
  }
  
 
  checkLogin(){
    this.loginservice.getEmployee(this.login).subscribe(data =>{
        this.employee = data;
        this.employeeService.currentEmployee = data;
        this.checkRole(this.employee);
      });
    } 

}
