import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowcomplaintsComponent } from './showcomplaints.component';

describe('ShowcomplaintsComponent', () => {
  let component: ShowcomplaintsComponent;
  let fixture: ComponentFixture<ShowcomplaintsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowcomplaintsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowcomplaintsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
