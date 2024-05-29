import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  user = new User();
  error = 0;
  message: string = "Login ou mot de passe incorrect";

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    
  }

  onLogin(){
    console.log(this.user);
    let isValidUser = this.authService.SignIn(this.user);
    if(isValidUser){
      this.router.navigate(['home']);
    }else{
      this.error = 1; 
    }
  }
}
