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
  erreur: number = 0;
  message: string = "Login ou mot de passe incorrect ...";

  constructor(
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
    
  }

  // onLoggedin(){
  //   console.log(this.user);
  //   this.authService.login(this.user).subscribe({
  //     next:(data)=> {
  //       let jwtToken = data.headers.get('Authorization')!;
  //       this.authService.saveToken(jwtToken);
  //       this.router.navigate(['/']);
  //     },error:(err: any )=>{
  //       this.error = 1; 
  //     }
  //   });
  // };

  onLoggedin()
  {
    console.log(this.user);
    let isValidUser: Boolean = this.authService.SignIn(this.user);
    if (isValidUser)
        this.router.navigate(['/']);
    else
       this.erreur=1;

  }


}
