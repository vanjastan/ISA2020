import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PatienthomeComponent } from './patienthome.component';

describe('PatienthomeComponent', () => {
  let component: PatienthomeComponent;
  let fixture: ComponentFixture<PatienthomeComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ PatienthomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatienthomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
