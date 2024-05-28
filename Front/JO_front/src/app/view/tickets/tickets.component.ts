import { Component, OnInit } from '@angular/core';
import { TicketService } from '../../services/ticket.service';
import { Ticket } from '../../model/ticket.model';

@Component({
  selector: 'app-tickets',
  templateUrl: './tickets.component.html',
  styleUrl: './tickets.component.css'
})
export class TicketsComponent implements OnInit{

  tickets?: Ticket[];

  constructor(private ticketService: TicketService) {
    
  }

  ngOnInit(): void {
    this.tickets =this.ticketService.listTickets();
  }

  deleteTicket(ticket: Ticket){
    console.log(ticket);
    this.ticketService.deleteTicket(ticket);
  }

  updateTicket(ticket: Ticket){
    console.log(ticket);
    this.ticketService.updateTicket(ticket);
  }
}
