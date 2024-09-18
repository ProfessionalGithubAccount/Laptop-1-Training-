import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewformsComponent } from './newforms.component';

describe('NewformsComponent', () => {
  let component: NewformsComponent;
  let fixture: ComponentFixture<NewformsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewformsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewformsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
