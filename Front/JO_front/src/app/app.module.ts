import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { TicketsComponent } from './view/tickets/tickets.component';
import { OffersComponent } from './view/offers/offers.component';
import { AddOfferComponent } from './view/offers/add-offer/add-offer.component';
import { AddTicketComponent } from './view/tickets/add-ticket/add-ticket.component';
import { HomeComponent } from './view/home/home.component';
import { UpdateOfferComponent } from './view/offers/update-offer/update-offer.component';
import { UpdateTicketComponent } from './view/tickets/update-ticket/update-ticket.component';
import { HttpClientModule } from '@angular/common/http';
import { GetTicketsByofferComponent } from './view/tickets/get-tickets-byoffer/get-tickets-byoffer.component';
import { LoginComponent } from './view/login/login.component';
import { ForbiddenComponent } from './view/forbidden/forbidden.component';


@NgModule({
  declarations: [
    AppComponent,
    TicketsComponent,
    OffersComponent,
    AddOfferComponent,
    AddTicketComponent,
    HomeComponent,
    UpdateOfferComponent,
    UpdateTicketComponent,
    GetTicketsByofferComponent,
    LoginComponent,
    ForbiddenComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
