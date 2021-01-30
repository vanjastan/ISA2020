import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PenalsComponent } from './penals.component';

describe('PenalsComponent', () => {
  let component: PenalsComponent;
  let fixture: ComponentFixture<PenalsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ PenalsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PenalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
