import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleConsultationsComponent } from './schedule-consultations.component';

describe('ScheduleConsultationsComponent', () => {
  let component: ScheduleConsultationsComponent;
  let fixture: ComponentFixture<ScheduleConsultationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ScheduleConsultationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ScheduleConsultationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
