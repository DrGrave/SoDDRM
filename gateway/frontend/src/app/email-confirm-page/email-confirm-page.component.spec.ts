import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmailConfirmPageComponent } from './email-confirm-page.component';

describe('EmailConfirmPageComponent', () => {
  let component: EmailConfirmPageComponent;
  let fixture: ComponentFixture<EmailConfirmPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmailConfirmPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmailConfirmPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
