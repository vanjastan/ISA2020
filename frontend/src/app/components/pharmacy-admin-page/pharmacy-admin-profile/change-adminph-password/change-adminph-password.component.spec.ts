import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChangeAdminphPasswordComponent } from './change-adminph-password.component';

describe('ChangeAdminphPasswordComponent', () => {
  let component: ChangeAdminphPasswordComponent;
  let fixture: ComponentFixture<ChangeAdminphPasswordComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChangeAdminphPasswordComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChangeAdminphPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
