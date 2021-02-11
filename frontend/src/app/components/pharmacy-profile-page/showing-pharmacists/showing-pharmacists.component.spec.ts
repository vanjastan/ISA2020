import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowingPharmacistsComponent } from './showing-pharmacists.component';

describe('ShowingPharmacistsComponent', () => {
  let component: ShowingPharmacistsComponent;
  let fixture: ComponentFixture<ShowingPharmacistsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowingPharmacistsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowingPharmacistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
