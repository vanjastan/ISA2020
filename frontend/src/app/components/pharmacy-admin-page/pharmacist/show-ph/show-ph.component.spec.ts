import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowPHComponent } from './show-ph.component';

describe('ShowPHComponent', () => {
  let component: ShowPHComponent;
  let fixture: ComponentFixture<ShowPHComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowPHComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowPHComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
