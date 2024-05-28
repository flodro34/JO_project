import { Injectable } from '@angular/core';
import { Ticket } from '../model/ticket.model';
// import { DATE_PIPE_DEFAULT_OPTIONS, DATE_PIPE_DEFAULT_TIMEZONE, DatePipe, getLocaleDateTimeFormat } from '@angular/common';
// import { Offer } from '../model/offer.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { apiURL } from '../config';


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


  constructor(private http: HttpClient) { 

   }

  getTicket(id:number): Observable<Ticket>{
    const url = `${apiURL}/tickets/${id}`;
    return this.http.get<Ticket>(url);     
  }

  getAllTickets(): Observable<Ticket[]>{ 
    return this.http.get<Ticket[]>(apiURL);
  }

  addTicket(ticket: Ticket): Observable<Ticket>{
    const url = `${apiURL}/tickets}`;
    return this.http.post<Ticket>(url, ticket, httpOptions);
  }

  deleteTicket(id:number){
    const url = `${apiURL}/tickets/${id}`;
    return this.http.delete(url, httpOptions);
  }

  updateTicket(ticket: Ticket): Observable<Ticket> {
    const url = `${apiURL}/tickets}`;
    return this.http.put<Ticket>(url, ticket, httpOptions);
  }




}
