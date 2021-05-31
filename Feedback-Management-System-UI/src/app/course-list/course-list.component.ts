import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
  course : Course[];
  err : string;
  courseId : any;
  cName : any ; 
  p:number =1;
  
  constructor(private courseService : CourseService) { }
 
  ngOnInit(): void {
    this.courseService.getAll().subscribe(
      (data) => this.course = data,
      (err) => { console.log (err); this.err = "sorry. unable to retrieve data"}
    );
  }

  // SearchBox(){
  //   if(this.courseId == ""){
  //     this.ngOnInit();
  //   }else{
  //     this.course = this.course.filter(res => {
  //       return res.courseId.toString().match(this.courseId.toString());
  //     });
  //   }
  // }

    Search(){
      if(this.cName == ""){
        this.ngOnInit();
      }else{
        this.course = this.course.filter(res => {
          return res.courseName.toLocaleLowerCase().match(this.cName.toLocaleLowerCase());
        });
      }

    

  
  }
  delete(courseId : number) {
    console.log(courseId);
    if (confirm("Are you sure?")) {
      this.courseService.removeCourse(courseId).subscribe(
        () => { this.course.splice(this.course.findIndex(c => c.courseId == courseId), 1) }
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
