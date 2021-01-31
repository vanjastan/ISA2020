import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ScheduleExaminationsComponent } from './schedule-examinations.component';

describe('ScheduleExaminationsComponent', () => {
  let component: ScheduleExaminationsComponent;
  let fixture: ComponentFixture<ScheduleExaminationsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ScheduleExaminationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleExaminationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
