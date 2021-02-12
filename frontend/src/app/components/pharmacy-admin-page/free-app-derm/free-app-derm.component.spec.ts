import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreeAppDermComponent } from './free-app-derm.component';

describe('FreeAppDermComponent', () => {
  let component: FreeAppDermComponent;
  let fixture: ComponentFixture<FreeAppDermComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FreeAppDermComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FreeAppDermComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
