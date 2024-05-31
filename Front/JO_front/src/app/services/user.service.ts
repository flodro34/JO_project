import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders} from '@angular/common/http';
import { User } from '../model/user.model';
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

export class UserService {

  apiURL = 'http://localhost:8080/JO/api/users';
  loggedUser: string | null = null;
  isloggedIn: boolean = false;
  roles: string[] = [];

  constructor(private http: HttpClient) { }

  getUser(id:number): Observable<User>{
    const url = `${this.apiURL}/${id}`;
    return this.http.get<User>(url);
  }

  getAllUsers(): Observable<User[]>{

    return this.http.get<User[]>(this.apiURL);
  }

  addUser(user: User): Observable<User>{
    user.tokenUser = CustomTokenUtil.generateCustomToken();
    return this.http.post<User>(this.apiURL, user, httpOptions);
  }

  deleteUser(id:number){
    const url = `${this.apiURL}/${id}`;
    return this.http.delete(url, httpOptions);
  }

  updateUser(user: User): Observable<User>{
    return this.http.put<User>(this.apiURL, user, httpOptions);
  }

  SignIn(user: User): Observable<boolean> {
    return new Observable<boolean>(observer => {
      this.http.post<User>(`${this.apiURL}/authenticate`, user, httpOptions).subscribe(
        (authenticatedUser) => {
          if (authenticatedUser) {
            this.loggedUser = authenticatedUser.username;
            this.isloggedIn = true;
            
            localStorage.setItem('loggedUser', this.loggedUser);
            localStorage.setItem('isloggedIn', String(this.isloggedIn));
            observer.next(true);
          } else {
            observer.next(false);
          }
          observer.complete();
        },
        error => {
          observer.next(false);
          observer.complete();
        }
      );
    });
  }

  logout() {
    localStorage.removeItem('loggedUser');
    localStorage.removeItem('isloggedIn');
    this.loggedUser = null;
    this.isloggedIn = false;
    this.roles = [];
  }






}
