import { Injectable } from '@angular/core';
import { Ticket } from '../model/ticket.model';
// import { DATE_PIPE_DEFAULT_OPTIONS, DATE_PIPE_DEFAULT_TIMEZONE, DatePipe, getLocaleDateTimeFormat } from '@angular/common';
// import { Offer } from '../model/offer.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiURL } from '../config';
import { CustomTokenUtil } from '../Utils/custom-token-util';
import { Transaction } from '../model/transaction.model';
import { TransactionService } from './transaction.service';
// import { AuthService } from './auth.service';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  tickets: Ticket[] | undefined;
  apiURLTick = 'http://localhost:8080/JO/api/tickets';
  

  constructor(private http: HttpClient, 
    private transactionService: TransactionService
  ) { 

   }

  getTicket(id:number): Observable<Ticket>{
    const url = `${apiURL}/tickets/${id}`;
    return this.http.get<Ticket>(url);     
  }

  getAllTickets(): Observable<Ticket[]>{ 
    // let jwt = this.authService.getToken();
    // jwt = "Bearer " + jwt;
    // let httpHeaders = new HttpHeaders().set('Authorization', jwt);
    return this.http.get<Ticket[]>(this.apiURLTick);
    
  }


  addTicket(ticket: Ticket): Observable<Ticket>{
    
    // Generate tokens
        const tokenUser = CustomTokenUtil.generateCustomToken();
        const tokenTransaction = CustomTokenUtil.generateCustomToken();

    // Create transaction
    const transaction = new Transaction();
    transaction.tokenTransaction = tokenTransaction;
    transaction.date = new Date();
    transaction.amount = Number(ticket.typeOffer.price);
    return new Observable(observer => {
      this.transactionService.addTransaction(transaction).subscribe(savedTransaction => {

        // Update ticket with tokens
        ticket.tokenUser = tokenUser;
        ticket.tokenTransaction = savedTransaction.tokenTransaction;
        ticket.tokenTicket = `${ticket.tokenUser}-${ticket.tokenTransaction}`;

        // Save ticket
        this.http.post<Ticket>(this.apiURLTick, ticket, httpOptions).subscribe(savedTicket => {
          observer.next(savedTicket);
          observer.complete();
        }, error => {
          observer.error(error);
        });
      }, error => {
        observer.error(error);
      });
    });
  }

  deleteTicket(id:number){
    const url = `${apiURL}/tickets/${id}`;
    return this.http.delete(url, httpOptions);
  }

  updateTicket(ticket: Ticket): Observable<Ticket> {
    const url = `${apiURL}/tickets}`;
    return this.http.put<Ticket>(url, ticket, httpOptions);
  }

  getByOffer(idOffer: number): Observable<Ticket[]>{ 
    const url = `${apiURL}/tickets/tickoff/${idOffer}`;
    return this.http.get<Ticket[]>(url);
  }




}
