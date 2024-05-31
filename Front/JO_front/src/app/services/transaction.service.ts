import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Transaction } from '../model/transaction.model';
import { Observable } from 'rxjs';
import { CustomTokenUtil } from '../Utils/custom-token-util';



const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};


@Injectable({
  providedIn: 'root'
})

export class TransactionService {

  apiURL = 'http://localhost:8080/JO/api/transactions';
  transaction? : Transaction[] ;

  constructor(private http: HttpClient) { }

  getTransaction(id:number): Observable<Transaction>{
    const url = `${this.apiURL}/${id}`;
    return this.http.get<Transaction>(url);
  }

  getAllTransactions(): Observable<Transaction[]>{

    return this.http.get<Transaction[]>(this.apiURL);
  }

  addTransaction(transaction: Transaction): Observable<Transaction>{
    transaction.tokenTransaction = CustomTokenUtil.generateCustomToken();
    transaction.date = new Date(); // Set the current date
    return this.http.post<Transaction>(this.apiURL, transaction, httpOptions);
  }

  deleteTransaction(id:number){
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }

  updateTransaction(transaction: Transaction): Observable<Transaction>{
    return this.http.put<Transaction>(this.apiURL, transaction, httpOptions);
  }





}
