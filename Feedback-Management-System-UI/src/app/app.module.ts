import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { EmployeeComponent } from './employee/employee.component';
import { EmpListComponent } from './emp-list/emp-list.component';
import { EmpFormComponent } from './emp-form/emp-form.component';

import { HeaderComponent } from './header/header.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
import { OrderModule } from 'ngx-order-pipe';
import { LoginComponent } from './login/login.component';
import { CoordinatorComponent } from './coordinator/coordinator.component';
import { ParticipantComponent } from './participant/participant.component';
import { FeedbackForCoordinatorComponent } from './feedback-for-coordinator/feedback-for-coordinator.component';


import { CourseComponent } from './course/course.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { ProgramComponent } from './program/program.component';
import { ProgramFormComponent } from './program-form/program-form.component';
import { CourseListComponent } from './course-list/course-list.component';
import { ProgramListComponent } from './program-list/program-list.component';
import { MsgboxComponent } from './msgbox/msgbox.component';
import { FooterComponent } from './footer/footer.component';
import { AdminComponent } from './admin/admin.component';
import { AddTrainerComponent } from './add-trainer/add-trainer.component';
import { AddParticipantComponent } from './add-participant/add-participant.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { CoordinatorHomeComponent } from './coordinator-home/coordinator-home.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { ParticipantHomeComponent } from './participant-home/participant-home.component';
import { FeedbackProgramFormComponent } from './feedback-program-form/feedback-program-form.component';
import { FeedbackTrainerFormComponent } from './feedback-trainer-form/feedback-trainer-form.component';
import { FeedbackTrainerComponent } from './feedback-trainer/feedback-trainer.component';
import { ProgramEnrollFormComponent } from './program-enroll-form/program-enroll-form.component';
import { ProgramEnrollListComponent } from './program-enroll-list/program-enroll-list.component';
import { ProgFeedListComponent } from './prog-feed-list/prog-feed-list.component';
import { TrainerFeedListComponent } from './trainer-feed-list/trainer-feed-list.component';
import { ViewFeedbackComponent } from './view-feedback/view-feedback.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EmployeeComponent,
    EmpListComponent,
    EmpFormComponent,
    HeaderComponent,
    LoginComponent,
    CoordinatorComponent,
    ParticipantComponent,
    FeedbackForCoordinatorComponent,
    CourseComponent,
    CourseFormComponent,
    ProgramComponent,
    ProgramFormComponent,
    CourseListComponent,
    ProgramListComponent,
    MsgboxComponent,
    FooterComponent,
    AdminComponent,
    AddTrainerComponent,
    AddParticipantComponent,
    DashboardComponent,
    CoordinatorHomeComponent,
    AdminHomeComponent,
    ParticipantHomeComponent,
    FeedbackProgramFormComponent,
    FeedbackTrainerFormComponent,
    FeedbackTrainerComponent,

    ProgramEnrollFormComponent,
    ProgramEnrollListComponent,
    ProgFeedListComponent,
    TrainerFeedListComponent,
    ViewFeedbackComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    FormsModule, 
    OrderModule
   
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
function Ng2OrderModule(Ng2OrderModule: any) {
  throw new Error('Function not implemented.');
}

