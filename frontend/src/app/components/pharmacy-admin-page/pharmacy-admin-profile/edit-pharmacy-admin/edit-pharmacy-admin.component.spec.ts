import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPharmacyAdminComponent } from './edit-pharmacy-admin.component';

describe('EditPharmacyAdminComponent', () => {
  let component: EditPharmacyAdminComponent;
  let fixture: ComponentFixture<EditPharmacyAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPharmacyAdminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPharmacyAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
