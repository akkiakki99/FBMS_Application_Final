import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddParticipantComponent } from './add-participant/add-participant.component';
import { AddTrainerComponent } from './add-trainer/add-trainer.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AdminComponent } from './admin/admin.component';
import { CoordinatorHomeComponent } from './coordinator-home/coordinator-home.component';
import { CoordinatorComponent } from './coordinator/coordinator.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseComponent } from './course/course.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { EmpFormComponent } from './emp-form/emp-form.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmployeeComponent } from './employee/employee.component';
import { FeedbackProgramFormComponent } from './feedback-program-form/feedback-program-form.component';
import { FeedbackTrainerFormComponent } from './feedback-trainer-form/feedback-trainer-form.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ParticipantHomeComponent } from './participant-home/participant-home.component';
import { ParticipantComponent } from './participant/participant.component';
import { ProgFeedListComponent } from './prog-feed-list/prog-feed-list.component';
import { ProgramEnrollFormComponent } from './program-enroll-form/program-enroll-form.component';
import { ProgramFormComponent } from './program-form/program-form.component';
import { ProgramListComponent } from './program-list/program-list.component';
import { ProgramComponent } from './program/program.component';
import { TFeedbackListComponent } from './t-feedback-list/t-feedback-list.component';
import { TrainerFeedListComponent } from './trainer-feed-list/trainer-feed-list.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';

const routes: Routes = [
  {
    path: 'coordinator', component: CoordinatorComponent, children: [
      { path: 'feedback', component: ViewFeedbackComponent,children:[
        { path: 'feedbackprogram', component: ProgFeedListComponent },
        { path: 'feedbacktrainer', component: TrainerFeedListComponent },
      ] },
      { path: 'coordinatorhome', component: CoordinatorHomeComponent },
      {
        path: 'program', component: ProgramComponent, children: [
          { path: 'list', component: ProgramListComponent },
          { path: 'add', component: ProgramFormComponent },
          { path: 'edit/:pid', component: ProgramFormComponent },
          { path: 'role/:erole', component: EmployeeComponent },
          { path: 'enroll', component: ProgramEnrollFormComponent }
        ]
      },
      { path: '', redirectTo: 'coordinatorhome', pathMatch: 'full' }
    ]
  },
  {
    path: 'admin', component: EmployeeComponent, children: [
      { path: 'feedback', component: ViewFeedbackComponent, children: [
        { path: 'feedbackprogram', component: ProgFeedListComponent },
        { path: 'feedbacktrainer', component: TrainerFeedListComponent },
      ] },
      { path: 'adminhome', component: AdminHomeComponent },

      {
        path: 'employee', component: AdminComponent, children: [
          { path: 'list', component: EmpListComponent },
          { path: 'add', component: EmpFormComponent },
          { path: 'edit/:eid', component: EmpFormComponent },
          { path: 'coordinator', component: AddTrainerComponent },
          { path: 'participant', component: AddParticipantComponent },
        ]
      },
      {
        path: 'course', component: CourseComponent, children: [
          { path: 'list', component: CourseListComponent },
          { path: 'add', component: CourseFormComponent },
          { path: 'edit/:cid', component: CourseFormComponent },
        ]
      },
      { path: '', redirectTo: 'adminhome', pathMatch: 'full' }
    ]
  },
  {
    path: 'participant', component: ParticipantComponent, children: [
      { path: 'homeparticipant', component: ParticipantHomeComponent },
      // {path: 'list',component: TFeedbackListComponent},
      { path: 'add', component: FeedbackTrainerFormComponent },
      { path: 'addp', component: FeedbackProgramFormComponent },
      { path: '', redirectTo: 'homeparticipant', pathMatch: 'full' }
    ]
  },

  { path: '', redirectTo: 'dashboard/home', pathMatch: "full" },
  { path: '*', redirectTo: 'dashboard', pathMatch: "full" },
  {
    path: 'dashboard', component: DashboardComponent, children: [
      { path: 'home', component: HomeComponent },
      { path: 'login', component: LoginComponent },
      { path: '', redirectTo: 'home', pathMatch: 'full' }
    ]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


