import { Injectable } from '@angular/core';
import { Ticket } from '../model/ticket.model';
import { DATE_PIPE_DEFAULT_OPTIONS, DATE_PIPE_DEFAULT_TIMEZONE, DatePipe, getLocaleDateTimeFormat } from '@angular/common';
import { Offer } from '../model/offer.model';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  tickets : Ticket[];
  ticket!: Ticket;


  constructor() { 
   
    this.tickets = [
      {idTicket: 7, typeOffer: {idOffer: 1, type: "Solo", price: "100"}, date : new Date("2024-06-15"), tokenTicket: "tutu", tokenUser:"userToken1", tokenTransaction:"transactionToken1"},
      {idTicket: 8, typeOffer: {idOffer: 2, type: "Duo", price: "200"}, date : new Date("2024-05-20"), tokenTicket: "toto", tokenUser:"userToken1", tokenTransaction:"transactionToken2"},
      {idTicket: 9, typeOffer: {idOffer: 3, type: "Familly", price: "300"}, date : new Date("2024-06-28"), tokenTicket: "tata", tokenUser:"userToken1", tokenTransaction:"transactionToken3"},
    ];
  }

  listTickets(): Ticket[]{
    return this.tickets;
  }

  addTicket(ticket: Ticket){
    this.tickets.push(ticket);
  }

  deleteTicket(ticket: Ticket){
    this.tickets = this.tickets.filter(t => t.idTicket !== ticket.idTicket);
  }

  updateTicket(ticket: Ticket){
    this.tickets = this.tickets.map(t => t.idTicket === ticket.idTicket ? ticket : t);  
  }

  getTicket(id:number): Ticket{
    return this.tickets.find(t => t.idTicket == id)!;
        
  }


}
