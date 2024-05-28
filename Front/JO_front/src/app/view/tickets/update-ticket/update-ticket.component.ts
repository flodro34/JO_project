import { Component } from '@angular/core';
import { Ticket } from '../../../model/ticket.model';
import { ActivatedRoute, Router } from '@angular/router';
import { TicketService } from '../../../services/ticket.service';
import { Offer } from '../../../model/offer.model';
import { OfferService } from '../../../services/offer.service';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrl: './update-ticket.component.css'
})
export class UpdateTicketComponent {

  currentTicket = new Ticket();

  offers!: Offer[];
  updateOffId!: number;

  message: string = "";

  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private ticketService: TicketService,
    private offerService: OfferService
  ) 
    { }

    ngOnInit(): void {
      this.offerService.getAllOffers().
      subscribe(offs => {this.offers = offs;
      console.log(offs);
      });
  
      console.log(this.activatedRoute.snapshot.params['id']);
      this.ticketService.getTicket(this.activatedRoute.snapshot.params['id']).
      
      subscribe( ticket =>{ this.currentTicket = ticket; 
        this.updateOffId =   this.currentTicket.typeOffer!.idOffer!;
      
      } ) ;
      }


  
  updateTicket(){ 
    
    this.currentTicket.typeOffer = this.offers.find(off => off.idOffer == this.updateOffId)!;
    this.ticketService.updateTicket(this.currentTicket).subscribe(ticket => {
      console.log(ticket);}
 );

      this.message = "Ticket for " + this.currentTicket.date + " modify with success";
      console.log(this.currentTicket);

      setTimeout(() => {
        this.router.navigate(['tickets']);
      }, 1000); 
    }
  }





