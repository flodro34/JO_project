import { Component, OnInit } from '@angular/core';
import { Ticket } from '../../../model/ticket.model';
import { TicketService } from '../../../services/ticket.service';
import { Router } from '@angular/router';
import { Offer } from '../../../model/offer.model';
import { OfferService } from '../../../services/offer.service';

@Component({
  selector: 'app-add-ticket',
  templateUrl: './add-ticket.component.html',
  styleUrl: './add-ticket.component.css'
})
export class AddTicketComponent implements OnInit{

  newTicket = new Ticket();
  offers!: Offer[];
  newIdOff!: number;
  newOffer!: Offer;

  message: string = "";


  constructor(private ticketService: TicketService,
    private router: Router,
    private offerService: OfferService 
    ) {}

  ngOnInit(): void {
    this.offers = this.offerService.listOffers();
  }

  addTicket() {
    this.newOffer = this.offerService.readOffer(this.newIdOff); 
    this.newTicket.typeOffer = this.newOffer;
    console.log(this.newOffer);
    this.ticketService.addTicket(this.newTicket);
    this.message = "Ticket for " + this.newTicket.date + " buy with success";
    this.router.navigate(['tickets']);
  }
}