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
  user? : User[] ;

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








}
