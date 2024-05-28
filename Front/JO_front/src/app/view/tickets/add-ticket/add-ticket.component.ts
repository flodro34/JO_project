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
    this.offerService.getAllOffers().subscribe((offers) => {
      this.offers = offers;
      console.log(offers);
    });
  }

  addTicket() {
 
  this.newTicket.typeOffer = this.offers.find(off => off.idOffer == this.newIdOff)!;
  console.log(this.newTicket.typeOffer);
  this.ticketService.addTicket(this.newTicket).subscribe(ticket => {
    console.log(ticket);}
);

    this.message = "Ticket for " + this.newTicket.date + " modify with success";
    console.log(this.newTicket);

    setTimeout(() => {
      this.router.navigate(['tickets']);
    }, 1000); 
  }
    
}