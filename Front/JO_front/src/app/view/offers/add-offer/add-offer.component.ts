import { Component, OnInit } from '@angular/core';
import { Offer } from '../../../model/offer.model';
import { OfferService } from '../../../services/offer.service';


@Component({
  selector: 'app-add-offer',
  templateUrl: './add-offer.component.html',
  styleUrl: './add-offer.component.css'
})
export class AddOfferComponent implements OnInit{

  newOffer = new Offer();

  message :string | undefined;

  constructor(private offerService: OfferService) {}

  ngOnInit(): void {
   
  }

  addOffer() {
    this.offerService.addOffer(this.newOffer);
    this.message = "Offer " + this.newOffer.type + " added with success";
     console.log(this.newOffer);
  }



 



}
