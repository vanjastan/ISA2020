import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddActionsAndPromotionsComponent } from './add-actions-and-promotions.component';

describe('AddActionsAndPromotionsComponent', () => {
  let component: AddActionsAndPromotionsComponent;
  let fixture: ComponentFixture<AddActionsAndPromotionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddActionsAndPromotionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddActionsAndPromotionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
