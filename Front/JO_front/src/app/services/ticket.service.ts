import { Injectable } from '@angular/core';
import { Ticket } from '../model/ticket.model';
// import { DATE_PIPE_DEFAULT_OPTIONS, DATE_PIPE_DEFAULT_TIMEZONE, DatePipe, getLocaleDateTimeFormat } from '@angular/common';
// import { Offer } from '../model/offer.model';
import { Observable, catchError, of, switchMap } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { baseURL } from '../config';
import { CustomTokenUtil } from '../Utils/custom-token-util';
import { Transaction } from '../model/transaction.model';
import { TransactionService } from './transaction.service';
import { UserService } from './user.service';
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
    private transactionService: TransactionService,
    private userService: UserService
  ) { 

   }

  getTicket(id:number): Observable<Ticket>{
    const url = `${baseURL}/tickets/${id}`;
    return this.http.get<Ticket>(url);     
  }

  getAllTickets(): Observable<Ticket[]>{ 
    // let jwt = this.authService.getToken();
    // jwt = "Bearer " + jwt;
    // let httpHeaders = new HttpHeaders().set('Authorization', jwt);

    return this.http.get<Ticket[]>(this.apiURLTick);
    
  }
  


  // addTicket(ticket: Ticket): Observable<Ticket>{

  //   const loggedUser = localStorage.getItem('loggedUser'); 
  //   const userId = localStorage.getItem('userId');


  //   //ticket.tokenUser = currentUserUser.tokenUser;




  //   // Generate tokens
  //       //const tokenUser = CustomTokenUtil.generateCustomToken();
  //       const tokenTransaction = CustomTokenUtil.generateCustomToken();

  //   // Create transaction
  //   const transaction = new Transaction();
  //   transaction.tokenTransaction = tokenTransaction;
  //   transaction.date = new Date();
  //   transaction.amount = Number(ticket.typeOffer.price);
    
  //   return new Observable(observer => {
  //     this.transactionService.addTransaction(transaction).subscribe(savedTransaction => {

  //       // Update ticket with tokens
  //       //ticket.tokenUser = tokenUser;
  //       ticket.tokenTransaction = savedTransaction.tokenTransaction;
  //       ticket.tokenTicket = `${ticket.tokenUser}-${ticket.tokenTransaction}`;

  //       // Save ticket
  //       this.http.post<Ticket>(this.apiURLTick, ticket, httpOptions).subscribe(savedTicket => {
  //         observer.next(savedTicket);
  //         observer.complete();
  //       }, error => {
  //         observer.error(error);
  //       });
  //     }, error => {
  //       observer.error(error);
  //     });
  //   });
  // }

  getAllTicketsByUser(): Observable<Ticket[]> {
    const loggedTokenUser = localStorage.getItem('userToken');
    const url = `${this.apiURLTick}/user/${loggedTokenUser}`;
    return this.http.get<Ticket[]>(url);
  }

  getAllTicketsByTokenUser(tokenUser: string): Observable<Ticket[]> {
    return this.http.get<Ticket[]>(`${baseURL}/tickets/by-token?tokenUser=${tokenUser}`);
  }

  // addTicket(ticket: Ticket): Observable<Ticket> {
  //   return this.userService.getUserConnected().pipe(
  //     switchMap(user => {
  //       if (!user) {
  //         throw new Error('User is null');
  //       }
  //       ticket.tokenUser = user.tokenUser;

  //       const tokenTransaction = CustomTokenUtil.generateCustomToken();

  //       const transaction = new Transaction();
  //       transaction.tokenTransaction = tokenTransaction;
  //       transaction.date = new Date();
  //       transaction.amount = Number(ticket.typeOffer.price);

  //       return this.transactionService.addTransaction(transaction).pipe(
  //         switchMap(savedTransaction => {
  //           ticket.tokenTransaction = savedTransaction.tokenTransaction;
  //           ticket.tokenTicket = `${ticket.tokenUser}-${ticket.tokenTransaction}`;

  //           return this.http.post<Ticket>(this.apiURLTick, ticket, httpOptions);
  //         })
  //       );
  //     }),
  //     catchError(error => {
  //       console.error('Error creating ticket', error);
  //       return of({} as Ticket);
  //     })
  //   );
  // }

  addTicket(ticket: Ticket): Observable<Ticket> {
    const loggedUserToken = localStorage.getItem('userToken');
    ticket.tokenUser = loggedUserToken || '';

    const tokenTransaction = CustomTokenUtil.generateCustomToken();

    const transaction = new Transaction();
    transaction.tokenTransaction = tokenTransaction;
    transaction.date = new Date();
    transaction.amount = Number(ticket.typeOffer.price);

    return new Observable(observer => {
      this.transactionService.addTransaction(transaction).subscribe(savedTransaction => {
        ticket.tokenTransaction = savedTransaction.tokenTransaction;
        ticket.tokenTicket = `${ticket.tokenUser}-${ticket.tokenTransaction}`;

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
    const url = `${baseURL}/tickets/${id}`;
    return this.http.delete(url, httpOptions);
  }

  updateTicket(ticket: Ticket): Observable<Ticket> {
    const url = `${baseURL}/tickets}`;
    return this.http.put<Ticket>(url, ticket, httpOptions);
  }

  getByOffer(idOffer: number): Observable<Ticket[]>{ 
    const url = `${baseURL}/tickets/tickoff/${idOffer}`;
    return this.http.get<Ticket[]>(url);
  }

  getByUser(idUser: number): Observable<Ticket[]>{ 
    const url = `${baseURL}/tickets/user/${idUser}`;
    return this.http.get<Ticket[]>(url);
  }




}
