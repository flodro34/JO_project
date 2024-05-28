import { Component, OnInit } from '@angular/core';
import { Offer } from '../../model/offer.model';
import { OfferService } from '../../services/offer.service';


@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrl: './offers.component.css'
})
export class OffersComponent implements OnInit{

  offers? : Offer[];
  

  constructor(private offerService: OfferService) { 
    
  }

  ngOnInit(): void {
    this.offers = this.offerService.listOffers();
  }

  deleteOffer(offer: Offer){
    //console.log(offer);
    let conf = confirm("Are you sure you want to delete this offer?");
    if(conf){
      this.offerService.deleteOffer(offer);
    }
  }

  updateOffer(offer: Offer){
    //console.log(offer);
    this.offerService.updateOffer(offer);
  }

}
