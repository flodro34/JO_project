import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetTicketsByofferComponent } from './get-tickets-byoffer.component';

describe('GetTicketsByofferComponent', () => {
  let component: GetTicketsByofferComponent;
  let fixture: ComponentFixture<GetTicketsByofferComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [GetTicketsByofferComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GetTicketsByofferComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
