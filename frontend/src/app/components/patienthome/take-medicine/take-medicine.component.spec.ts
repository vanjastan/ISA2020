import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { TakeMedicineComponent } from './take-medicine.component';

describe('TakeMedicineComponent', () => {
  let component: TakeMedicineComponent;
  let fixture: ComponentFixture<TakeMedicineComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ TakeMedicineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TakeMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
