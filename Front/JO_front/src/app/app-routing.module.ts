import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TicketsComponent } from './view/tickets/tickets.component';
import { OffersComponent } from './view/offers/offers.component';
import { AddOfferComponent } from './view/offers/add-offer/add-offer.component';
import { HomeComponent } from './view/home/home.component';
import { AddTicketComponent } from './view/tickets/add-ticket/add-ticket.component';
import { UpdateOfferComponent } from './view/offers/update-offer/update-offer.component';
import { UpdateTicketComponent } from './view/tickets/update-ticket/update-ticket.component';


const routes: Routes = [
  {path: "tickets", component : TicketsComponent},
  {path: "add-ticket", component : AddTicketComponent},
  {path: "update-ticket/:id", component : UpdateTicketComponent},

  {path: "offers", component : OffersComponent},
  {path: "add-offer", component : AddOfferComponent},
  {path: "update-offer/:id", component : UpdateOfferComponent},

  {path: "home", component : HomeComponent},
  {path: "", redirectTo: "home", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
