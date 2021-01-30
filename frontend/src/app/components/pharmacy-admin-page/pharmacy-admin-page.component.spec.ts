import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { PharmacyAdminPageComponent } from './pharmacy-admin-page.component';

describe('PharmacyAdminPageComponent', () => {
  let component: PharmacyAdminPageComponent;
  let fixture: ComponentFixture<PharmacyAdminPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PharmacyAdminPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmacyAdminPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
