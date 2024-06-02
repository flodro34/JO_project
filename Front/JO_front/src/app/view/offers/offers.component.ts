import { Component, OnInit } from '@angular/core';
import { Offer } from '../../model/offer.model';
import { OfferService } from '../../services/offer.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrl: './offers.component.css'
})
export class OffersComponent implements OnInit{

  offers! : Offer[];
  

  constructor(private offerService: OfferService, public userService: UserService) { 
    
  }

  ngOnInit(): void {
    this.loadOffers();
  }

  loadOffers(){
    this.offerService.getAllOffers().subscribe((offers) => {
      this.offers = offers;
    });
  }

  deleteOffer(offer: Offer){
    let confirm = window.confirm("Are you sure you want to delete this offer ?");
    if (confirm){
      if (offer.idOffer) {
        this.offerService.deleteOffer(offer.idOffer).subscribe(() => {
          this.loadOffers();
        });
      }
    }
  }

}
