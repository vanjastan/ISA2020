import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrderformComponent } from './add-orderform.component';

describe('AddOrderformComponent', () => {
  let component: AddOrderformComponent;
  let fixture: ComponentFixture<AddOrderformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddOrderformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrderformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
