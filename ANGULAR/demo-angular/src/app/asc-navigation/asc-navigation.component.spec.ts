import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscNavigationComponent } from './asc-navigation.component';

describe('AscNavigationComponent', () => {
  let component: AscNavigationComponent;
  let fixture: ComponentFixture<AscNavigationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AscNavigationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AscNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
