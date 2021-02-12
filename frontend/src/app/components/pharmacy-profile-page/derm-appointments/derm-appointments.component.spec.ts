import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DermAppointmentsComponent } from './derm-appointments.component';

describe('DermAppointmentsComponent', () => {
  let component: DermAppointmentsComponent;
  let fixture: ComponentFixture<DermAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DermAppointmentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DermAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
