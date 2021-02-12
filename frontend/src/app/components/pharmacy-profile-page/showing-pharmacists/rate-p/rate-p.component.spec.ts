import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RatePComponent } from './rate-p.component';

describe('RatePComponent', () => {
  let component: RatePComponent;
  let fixture: ComponentFixture<RatePComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RatePComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RatePComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
