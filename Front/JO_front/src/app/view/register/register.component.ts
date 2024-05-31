import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{

  public user = new User();

  confirmPassword?: string = "";
  myForm!: FormGroup;
  
  err!:any;
  loading : boolean = false;

  constructor(private fb: FormBuilder, private authService : AuthService, 
    private router:Router, private toastr: ToastrService) {}

  ngOnInit(): void {
 
    this.myForm = this.fb.group({
      'firstname': ['', Validators.required],
      'email': ['', [Validators.required, Validators.email]],
      'password': ['', [Validators.required, Validators.minLength(6)]],
      'confirmPassword': ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onRegister(){
    
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


}

