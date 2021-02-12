import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GraphicsMComponent } from './graphics-m.component';

describe('GraphicsMComponent', () => {
  let component: GraphicsMComponent;
  let fixture: ComponentFixture<GraphicsMComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GraphicsMComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GraphicsMComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
