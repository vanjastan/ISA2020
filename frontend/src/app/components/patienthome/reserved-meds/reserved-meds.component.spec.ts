import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ReservedMedsComponent } from './reserved-meds.component';

describe('ReservedMedsComponent', () => {
  let component: ReservedMedsComponent;
  let fixture: ComponentFixture<ReservedMedsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ReservedMedsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReservedMedsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
