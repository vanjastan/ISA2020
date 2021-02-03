import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionsAndPromotionsComponent } from './actions-and-promotions.component';

describe('ActionsAndPromotionsComponent', () => {
  let component: ActionsAndPromotionsComponent;
  let fixture: ComponentFixture<ActionsAndPromotionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActionsAndPromotionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionsAndPromotionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
