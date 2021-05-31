import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {
  courseIdfc :FormControl;
  courseNamefc : FormControl;
  courseDesfc : FormControl;
  noOfDaysfc : FormControl;

  courseForm : FormGroup;
  isEditing : boolean;
  alert:boolean = false
  
  constructor(private courseService : CourseService, private router : Router,
    private activatedRoute : ActivatedRoute) {
    this.courseIdfc = new FormControl('0');
    this.courseNamefc = new FormControl(null, [Validators.required, Validators.minLength(3)]);
    this.courseDesfc = new FormControl(null, [Validators.required,  Validators.minLength(3)]);
    this.noOfDaysfc = new FormControl(null, [Validators.required, Validators.min(1), Validators.max(90)]);

    this.isEditing = false;

    this.courseForm = new FormGroup(
      {courseId : this.courseIdfc,
       courseName : this.courseNamefc,
       courseDescription : this.courseDesfc,
       noOfDays : this.noOfDaysfc,
      }
       );
     }

  ngOnInit(): void {
    let cid = this.activatedRoute.snapshot.params.cid;
    if (cid) {
      this.isEditing = true;
      this.courseService.getById(cid).subscribe(
        (data) => this.courseForm.setValue(data)
      );
    }

  }
   
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.courseService.updateCourse(this.courseForm.value);
    } else {
      obr = this.courseService.addCourse(this.courseForm.value);
    }
    obr.subscribe(
      this.courseForm.reset()
      );
      this.alert = true
    }
    closeAlert(){
      this.alert = false
    }

}
