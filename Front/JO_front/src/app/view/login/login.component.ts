import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  user = new User();
  erreur: number = 0;
  message: string = "Login ou mot de passe incorrect ...";

  constructor(
    private userService: UserService,
    //private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    
  }

  onLoggedin() {
    this.userService.SignIn(this.user).subscribe(
      (isValidUser) => {
        if (isValidUser) {
          this.router.navigate(['/']); 
          this.message = 'Invalid username or password';
        }
      },
      (error) => {
        this.message = 'An error occurred during login';
        console.error(error);
      }
    );
  }


}
