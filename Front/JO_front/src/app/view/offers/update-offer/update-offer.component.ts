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

  constructor(private activatedRoute: ActivatedRoute,
    private router :Router,
    private offerService: OfferService) { }

  ngOnInit(): void {
    console.log(this.activatedRoute.snapshot.params['id']);
    this.currentOffer = this.offerService.getOffer(this.activatedRoute.snapshot.params['id']);
    console.log(this.currentOffer);
  }

  updateOffer(){
    this.offerService.updateOffer(this.currentOffer);
    this.router.navigate(['offers']);
  }

}
