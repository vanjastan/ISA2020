import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddFreeAppComponent } from './add-free-app.component';

describe('AddFreeAppComponent', () => {
  let component: AddFreeAppComponent;
  let fixture: ComponentFixture<AddFreeAppComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddFreeAppComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddFreeAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
