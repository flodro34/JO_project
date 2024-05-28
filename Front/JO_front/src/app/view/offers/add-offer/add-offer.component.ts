import { Component, OnInit } from '@angular/core';
import { Offer } from '../../../model/offer.model';
import { OfferService } from '../../../services/offer.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-add-offer',
  templateUrl: './add-offer.component.html',
  styleUrl: './add-offer.component.css'
})
export class AddOfferComponent implements OnInit{

  newOffer = new Offer();

  message :string | undefined;

  constructor(private offerService: OfferService,
    private router: Router
  ) {}

  ngOnInit(): void {
   
  }

  addOffer() {
    this.offerService.addOffer(this.newOffer).subscribe(offer => {
      this.message = "Offer " + this.newOffer.type + " modify with success";
      console.log(this.newOffer);

      setTimeout(() => {
        this.router.navigate(['offers']);
      }, 1000); 
    });
  }



 



}
