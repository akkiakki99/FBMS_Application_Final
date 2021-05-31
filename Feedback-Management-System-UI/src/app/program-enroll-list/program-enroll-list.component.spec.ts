import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgramEnrollListComponent } from './program-enroll-list.component';

describe('ProgramEnrollListComponent', () => {
  let component: ProgramEnrollListComponent;
  let fixture: ComponentFixture<ProgramEnrollListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgramEnrollListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgramEnrollListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
