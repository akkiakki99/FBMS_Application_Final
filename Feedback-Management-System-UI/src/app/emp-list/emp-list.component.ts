import { Component, OnInit } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  emps : Employee[];
  err : string;
  Skill : any;
  Id : any;
  p:number =1;
  
  constructor(private empsService : EmployeeService) { }
 
  ngOnInit(): void {
    this.empsService.getAll().subscribe(
      (data) => this.emps = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }
  Search(){
    if(this.Skill == ""){
      this.ngOnInit();
    }else{
      this.emps = this.emps.filter(res => {
        return res.empSkill.toLocaleLowerCase().match(this.Skill.toLocaleLowerCase());
      });
    }
  }
  SearchBox(){
    if(this.Id == ""){
      this.ngOnInit();
    }else{
      this.emps = this.emps.filter(res => {
        return res.employeeName.toLocaleLowerCase().match(this.Id.toLocaleLowerCase());
      });
    }
  
  }
  delete(employeeId: number) {
    if (confirm("Are you sure?")) {
      this.empsService.deleteById(employeeId).subscribe(
        () => { this.emps.splice(this.emps.findIndex(e => e.employeeId == employeeId), 1) }
      );
    }
  }
  key : string = "employeeId";
  reverse : boolean = false;
  sort(key){
    this.key = key;
    this.reverse = !this.reverse;

  }
}
