import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmacysProfileComponent } from './pharmacys-profile.component';

describe('PharmacysProfileComponent', () => {
  let component: PharmacysProfileComponent;
  let fixture: ComponentFixture<PharmacysProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PharmacysProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacysProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
