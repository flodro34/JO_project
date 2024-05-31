import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'JO_front';

  constructor(public authService: AuthService,
    public router: Router
  ) { }

 ngOnInit(): void {
   
  let isLoggedIn: any ;
  let loggedUser: any;
  isLoggedIn = localStorage.getItem('isLoggedIn');
  loggedUser = localStorage.getItem('loggedUser');

  if(isLoggedIn!="true" || !loggedUser)
    this.router.navigate(['/login']);
  else
    this.authService.setLoggedUserFromLocalStorage(loggedUser);

 }
}
