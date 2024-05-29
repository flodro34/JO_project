import { Injectable } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  user:User[] = [{"idUser":1,"lastname":"fett","firstname":"bobba","tokenUser":"myToken", "email": "bobba@gmail.com", "password": "pwd", "isAdmin": true},
                  {"idUser":1,"lastname":"kenobi","firstname":"obiwan","tokenUser":"TokTok", "email": "obiwan@gmail.com", "password": "pwd2", "isAdmin": false},
];
 
public loggedUser!: string;
public isLogged!: boolean;
public isAdmin!: boolean;
public roles!: string[];

  
  
    constructor(private router: Router) { }

    SignIn(user: User){
        let validUser: Boolean = false;
        this.user.forEach(currentUser => {
            if(currentUser.email == user.email && currentUser.password == user.password){
                validUser = true;

                this.loggedUser = currentUser.firstname;
                this.isLogged = true;
                this.isAdmin = currentUser.isAdmin;
                

                localStorage.setItem('loggedUser', this.loggedUser);
                localStorage.setItem('isLogged', String (this.isLogged)); 
            }
        });

     return validUser;
    }

    SignOut(){
        this.isLogged = false;
        this.isAdmin = false;
        this.roles = undefined!;
        
        localStorage.removeItem('loggedUser');
        localStorage.setItem('isLogged', String (this.isLogged));
        
        this.router.navigate(['/login']);
    }

}
