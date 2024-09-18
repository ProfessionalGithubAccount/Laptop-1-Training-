import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColourmineComponent } from './colourmine.component';

describe('ColourmineComponent', () => {
  let component: ColourmineComponent;
  let fixture: ComponentFixture<ColourmineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ColourmineComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ColourmineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
