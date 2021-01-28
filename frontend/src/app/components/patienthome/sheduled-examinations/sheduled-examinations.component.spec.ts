import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SheduledExaminationsComponent } from './sheduled-examinations.component';

describe('SheduledExaminationsComponent', () => {
  let component: SheduledExaminationsComponent;
  let fixture: ComponentFixture<SheduledExaminationsComponent>;

  beforeEach(async(() => {
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
