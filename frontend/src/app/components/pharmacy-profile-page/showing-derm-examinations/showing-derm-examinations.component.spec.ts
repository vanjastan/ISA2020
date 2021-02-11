import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowingDermExaminationsComponent } from './showing-derm-examinations.component';

describe('ShowingDermExaminationsComponent', () => {
  let component: ShowingDermExaminationsComponent;
  let fixture: ComponentFixture<ShowingDermExaminationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowingDermExaminationsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowingDermExaminationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
