import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllpharmaciesComponent } from './allpharmacies.component';

describe('AllpharmaciesComponent', () => {
  let component: AllpharmaciesComponent;
  let fixture: ComponentFixture<AllpharmaciesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllpharmaciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllpharmaciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
