import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ExaminationsPharmComponent } from './examinations-pharm.component';

describe('ExaminationsPharmComponent', () => {
  let component: ExaminationsPharmComponent;
  let fixture: ComponentFixture<ExaminationsPharmComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ExaminationsPharmComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExaminationsPharmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
