import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestobservableComponent } from './testobservable.component';

describe('TestobservableComponent', () => {
  let component: TestobservableComponent;
  let fixture: ComponentFixture<TestobservableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TestobservableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TestobservableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
