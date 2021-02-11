import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientSubscribeComponent } from './patient-subscribe.component';

describe('PatientSubscribeComponent', () => {
  let component: PatientSubscribeComponent;
  let fixture: ComponentFixture<PatientSubscribeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatientSubscribeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PatientSubscribeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
