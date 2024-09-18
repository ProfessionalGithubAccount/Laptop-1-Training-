import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnextracompoComponent } from './ownextracompo.component';

describe('OwnextracompoComponent', () => {
  let component: OwnextracompoComponent;
  let fixture: ComponentFixture<OwnextracompoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OwnextracompoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnextracompoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
