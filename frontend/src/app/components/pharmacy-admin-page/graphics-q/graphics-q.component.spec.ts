import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GraphicsQComponent } from './graphics-q.component';

describe('GraphicsQComponent', () => {
  let component: GraphicsQComponent;
  let fixture: ComponentFixture<GraphicsQComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GraphicsQComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GraphicsQComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
