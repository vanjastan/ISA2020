import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { EMedsComponent } from './e-meds.component';

describe('EMedsComponent', () => {
  let component: EMedsComponent;
  let fixture: ComponentFixture<EMedsComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ EMedsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EMedsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
