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
    this.loadTickets();
  }

  loadTickets(){
    this.ticketService.getAllTickets().subscribe((tickets) => {
      this.tickets = tickets;
      console.log(tickets);
    });
  }

  deleteTicket(ticket: Ticket){
    let confirm = window.confirm("Are you sure you want to delete this ticket?");
    if (confirm){
      if (ticket.idTicket) {
        this.ticketService.deleteTicket(ticket.idTicket).subscribe(() => {
          this.loadTickets();
        });
      }
    }

    }

}
