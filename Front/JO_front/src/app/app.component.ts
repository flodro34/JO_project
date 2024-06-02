import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'JO_front';

  constructor(public authService: AuthService,
    public router: Router, 
    public userService: UserService
  ) { }

loggedUser: any;
isloggedIn: any;
roles: any;

  logout(){
    this.loggedUser = undefined!;
    this.isloggedIn = false;
    this.roles = undefined!
    localStorage.removeItem('loggedUser');
    localStorage.setItem('isloggedIn', String(this.isloggedIn));
    this.router.navigate(['/home']);
  }



 ngOnInit(): void {

  // this.isloggedIn = localStorage.getItem('isLoggedIn');
  // this.loggedUser = localStorage.getItem('loggedUser');

  // if(this.isloggedIn!="true" || !this.loggedUser)
  //   this.router.navigate(['/login']);
  // else
  //   this.authService.setLoggedUserFromLocalStorage(this.loggedUser);

 }


}
