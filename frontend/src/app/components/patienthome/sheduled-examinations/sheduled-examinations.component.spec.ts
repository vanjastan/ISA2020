import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { SheduledExaminationsComponent } from './sheduled-examinations.component';

describe('SheduledExaminationsComponent', () => {
  let component: SheduledExaminationsComponent;
  let fixture: ComponentFixture<SheduledExaminationsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ SheduledExaminationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SheduledExaminationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
