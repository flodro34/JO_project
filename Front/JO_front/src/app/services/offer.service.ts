import { Injectable } from '@angular/core';
import { Offer } from '../model/offer.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http';
// import { AuthService } from './auth.service';


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})

export class OfferService {

  apiURL = 'http://localhost:8080/JO/api/offers';
  offers? : Offer[] ;

  constructor(private http: HttpClient, 
    // private authService: AuthService
  ) { 

  }

  getOffer(id:number): Observable<Offer>{
    const url = `${this.apiURL}/${id}`;
    return this.http.get<Offer>(url);
  }

  getAllOffers(): Observable<Offer[]>{
    // let jwt = this.authService.getToken();
    // jwt = "Bearer " + jwt;
    // let httpHeaders = new HttpHeaders().set('Authorization', jwt);
    return this.http.get<Offer[]>(this.apiURL);
  }

  addOffer(offer: Offer): Observable<Offer>{
    return this.http.post<Offer>(this.apiURL, offer, httpOptions);
  }

  readOffer(id:number): Offer{
    return this.offers?.find(o => o.idOffer == id)!;
  }

  deleteOffer(id:number){
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }

  updateOffer(offer: Offer): Observable<Offer>{
    return this.http.put<Offer>(this.apiURL, offer, httpOptions);
  }

}
