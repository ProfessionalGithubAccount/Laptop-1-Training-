import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DatacomponentComponent } from './datacomponent.component';

describe('DatacomponentComponent', () => {
  let component: DatacomponentComponent;
  let fixture: ComponentFixture<DatacomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DatacomponentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DatacomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
