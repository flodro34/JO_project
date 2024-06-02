import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TicketsComponent } from './view/tickets/tickets.component';
import { OffersComponent } from './view/offers/offers.component';
import { AddOfferComponent } from './view/offers/add-offer/add-offer.component';
import { HomeComponent } from './view/home/home.component';
import { AddTicketComponent } from './view/tickets/add-ticket/add-ticket.component';
import { UpdateOfferComponent } from './view/offers/update-offer/update-offer.component';
import { UpdateTicketComponent } from './view/tickets/update-ticket/update-ticket.component';
import { GetTicketsByofferComponent } from './view/tickets/get-tickets-byoffer/get-tickets-byoffer.component';
import { LoginComponent } from './view/login/login.component';
// import { AdminGuard } from './gards/admin.guard';
import { ForbiddenComponent } from './view/forbidden/forbidden.component';
import { RegisterComponent } from './view/register/register.component';



const routes: Routes = [
  {path: "tickets", component : TicketsComponent},
  {path: "add-ticket", component : AddTicketComponent},
  {path: "update-ticket/:id", component : UpdateTicketComponent},
  {path: "tickoff", component : GetTicketsByofferComponent},

  {path: "offers", component : OffersComponent},
  {path: "add-offer", component : AddOfferComponent},
  {path: "update-offer/:id", component : UpdateOfferComponent },

  {path: "home", component : HomeComponent},
  {path: "login", component : LoginComponent},
  {path: "register", component : RegisterComponent},
  {path: "app-forbidden", component : ForbiddenComponent},
  {path: "", redirectTo: "home", pathMatch: "full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
