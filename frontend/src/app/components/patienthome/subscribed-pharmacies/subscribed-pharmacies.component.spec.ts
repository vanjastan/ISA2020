import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { SubscribedPharmaciesComponent } from './subscribed-pharmacies.component';

describe('SubscribedPharmaciesComponent', () => {
  let component: SubscribedPharmaciesComponent;
  let fixture: ComponentFixture<SubscribedPharmaciesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ SubscribedPharmaciesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedPharmaciesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
