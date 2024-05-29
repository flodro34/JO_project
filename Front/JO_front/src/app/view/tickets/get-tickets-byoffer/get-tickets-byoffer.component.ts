import { Component, OnInit } from '@angular/core';
import { Offer } from '../../../model/offer.model';
import { Ticket } from '../../../model/ticket.model';
import { TicketService } from '../../../services/ticket.service';
import { OfferService } from '../../../services/offer.service';

@Component({
  selector: 'app-get-tickets-byoffer',
  templateUrl: './get-tickets-byoffer.component.html',
  styleUrl: './get-tickets-byoffer.component.css'
})
export class GetTicketsByofferComponent implements OnInit{

  idOffer!: number;
  offers!: Offer[];
  tickets!: Ticket[]; 
  

  constructor(private ticketService: TicketService, private offerService: OfferService) {}

  ngOnInit(): void {
    this.offerService.getAllOffers().subscribe((offers) => {
      this.offers = offers;
    });
  }

  getTicketsByOffer(){
    this.ticketService.getByOffer(this.idOffer).subscribe((tickets) => {
      this.tickets = tickets;
    });
  }



}
