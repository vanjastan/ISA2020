import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllDermComponent } from './all-derm.component';

describe('AllDermComponent', () => {
  let component: AllDermComponent;
  let fixture: ComponentFixture<AllDermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllDermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllDermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
