import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowingDermatologistsComponent } from './showing-dermatologists.component';

describe('ShowingDermatologistsComponent', () => {
  let component: ShowingDermatologistsComponent;
  let fixture: ComponentFixture<ShowingDermatologistsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowingDermatologistsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowingDermatologistsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
