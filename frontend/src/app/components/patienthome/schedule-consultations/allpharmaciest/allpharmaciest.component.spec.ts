import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllpharmaciestComponent } from './allpharmaciest.component';

describe('AllpharmaciestComponent', () => {
  let component: AllpharmaciestComponent;
  let fixture: ComponentFixture<AllpharmaciestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllpharmaciestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllpharmaciestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
