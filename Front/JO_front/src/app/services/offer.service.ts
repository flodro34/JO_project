import { Injectable } from '@angular/core';
import { Offer } from '../model/offer.model';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  offers : Offer[];
  offer!: Offer;

  constructor() { 
    
    this.offers = [
      {idOffer: 1, type: "Solo", price: "100"},
      {idOffer: 2, type: "Duo", price: "200"},
      {idOffer: 3, type: "Familly", price: "300"},
    ];
  }

  listOffers(): Offer[]{
    return this.offers;
  }

  addOffer(offer: Offer){
    this.offers.push(offer);
  }

  deleteOffer(offer: Offer){
    this.offers = this.offers.filter(o => o.idOffer !== offer.idOffer);
  }

  updateOffer(offer: Offer){
  this.offers = this.offers.map(o => o.idOffer === offer.idOffer ? offer : o); 
  }


  getOffer(id:number): Offer{
  return this.offers.find(p => p.idOffer == id)!;
      
  }

  readOffer(id:number): Offer{
    return this.offers.find(o => o.idOffer == id)!;
  }

}
