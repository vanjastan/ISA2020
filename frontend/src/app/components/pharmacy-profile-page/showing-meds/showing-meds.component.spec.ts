import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowingMedsComponent } from './showing-meds.component';

describe('ShowingMedsComponent', () => {
  let component: ShowingMedsComponent;
  let fixture: ComponentFixture<ShowingMedsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowingMedsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowingMedsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
