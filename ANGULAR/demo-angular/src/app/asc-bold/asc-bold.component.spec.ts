import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscBoldComponent } from './asc-bold.component';

describe('AscBoldComponent', () => {
  let component: AscBoldComponent;
  let fixture: ComponentFixture<AscBoldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AscBoldComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AscBoldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
