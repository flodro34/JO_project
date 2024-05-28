import { Component, OnInit } from '@angular/core';
import { Offer } from '../../../model/offer.model';
import { ActivatedRoute, Router } from '@angular/router';
import { OfferService } from '../../../services/offer.service';

@Component({
  selector: 'app-update-offer',
  templateUrl: './update-offer.component.html',
  styleUrl: './update-offer.component.css'
})
export class UpdateOfferComponent implements OnInit{

  currentOffer = new Offer();

  message: string = "";

  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private offerService: OfferService) { }

  ngOnInit(): void {
    this.offerService.getOffer(this.activatedRoute.snapshot.params['id']).subscribe(offer => {
      this.currentOffer = offer;
    });;
  }

  updateOffer(){
    this.offerService.updateOffer(this.currentOffer).subscribe(offer => {
      this.message = "Offer " + this.currentOffer.type + " modify with success";
      console.log(this.currentOffer);

      setTimeout(() => {
        this.router.navigate(['offers']);
      }, 1000); 
    });

  }

}
