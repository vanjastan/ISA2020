import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmaciesFreeDermComponent } from './pharmacies-free-derm.component';

describe('PharmaciesFreeDermComponent', () => {
  let component: PharmaciesFreeDermComponent;
  let fixture: ComponentFixture<PharmaciesFreeDermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PharmaciesFreeDermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmaciesFreeDermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
