import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from '../../services/user.service';
import { CustomTokenUtil } from '../../Utils/custom-token-util';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})


export class RegisterComponent {

  user: User = new User();
  message: string = '';

  constructor(private userService: UserService) {}

  registerUser() {

    // Generate token before sending data to backend
    this.user.tokenUser = CustomTokenUtil.generateCustomToken();

    this.userService.addUser(this.user).subscribe(
      response => {
        this.message = 'Inscription réussie !!';
      },
      error => {
        this.message = "Une erreur est survenue lors de l\'enregistrement";
        console.error(error);
      }
    );
  }

  //onRegister(){
    
  //   console.log(this.user);

  //   this.loading=true;
  //   this.authService.registerUser(this.user).subscribe({
  //     next:(res)=>{
  //       this.authService.setRegistredUser(this.user);
  //       // alert("veillez confirmer votre email");
  //       this.loading=false;
  //       this.toastr.success('Veuillez confirmer votre email', 'Confirmation');
  //       this.router.navigate(["/verifEmail"]);
  //       },
  //       error:(err:any)=>{
  //         if(err.error.errorCode=="USER_EMAIL_ALREADY_EXISTS"){
  //               this.err= "Email already used";
  //         }
  //       }
  //   });
}




