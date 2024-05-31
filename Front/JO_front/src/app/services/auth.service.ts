import { Injectable } from '@angular/core';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

    // users:User[] = [{"idUser":1,"username":"Bob","lastname":"fett","firstname":"bobba","tokenUser":"myToken", "email": "bobba@gmail.com", "password": "123", "roles":['USER'], "enabled":true},
    //                 {"idUser":2,"username":"Ben","lastname":"kenobi","firstname":"obiwan","tokenUser":"TokTok", "email": "obiwan@gmail.com", "password": "123", "roles":['ADMIN'], "enabled":true},
    // ];

    //private helper = new JwtHelperService();

    users!: User[];

    //baseURL: string = 'http://localhost:8081/users';
    apiURL: string = 'http://localhost:8080/JO/api/users';
    token!:string;

    public regitredUser: User = new User();

    public loggedUser!: string;
    public isloggedIn: boolean = false;
    public roles!: string[];

  
  
    constructor(private router : Router,
        private http : HttpClient) { }

    setRegistredUser(user : User){
        this.regitredUser = user;
        }
        
    getRegistredUser(){
        return this.regitredUser;
    }

    // login(user : User){
    //     return this.http.post<User>(this.apiURL+'/login', user , {observe:'response'});
    // }

    // saveToken(jwt:string){
    //     localStorage.setItem('jwt',jwt);
    //     this.token = jwt;
    //     this.isLoggedin = true;
         
    //     //this.decodeJWT();
    // }
  
    // getToken():string {
    //     return this.token;
    // }
  
    // decodeJWT(){
    //     if (this.token == undefined)
    //         return;
    //     const decodedToken = this.helper.decodeToken(this.token);
    //     this.roles = decodedToken.roles;
    //     this.loggedUser = decodedToken.sub;
    // }

    // SignIn(user: User): Boolean {
    //     let validUser: Boolean = false;
    //     this.users.forEach((curUser) => {
    //       if (user.username == curUser.username && user.password == curUser.password) {
    //         validUser = true;
    //         this.loggedUser = curUser.username;
    //         this.isloggedIn = true;
    //         this.roles = curUser.roles;
    //         localStorage.setItem('loggedUser', this.loggedUser);
    //         localStorage.setItem('isloggedIn', String(this.isloggedIn));
    //       }
    //     });
    //     return validUser;
    //   }

    // isAdmin():Boolean{ 
    //     if (!this.roles) //this.roles== undefiened 
    //         return false; return (this.roles.indexOf('ADMIN') >-1);
    //     }

    // logout(){
    //     this.loggedUser = undefined!;
    //     this.isloggedIn = false;
    //     this.roles = undefined!
    //     localStorage.removeItem('loggedUser');
    //     localStorage.setItem('isloggedIn', String(this.isloggedIn));
    //     this.router.navigate(['/home']);
    // }

    // setLoggedUserFromLocalStorage(login: string) {
    //     this.loggedUser = login;
    //     this.isloggedIn = true;
    //     this.getUserRoles(login);
    // }

    // getUserRoles(username: string){
    //     this.users.forEach((curUser)=>{
    //         if(curUser.username == username){
    //             this.roles = curUser.roles;
    //         }
    //     });
    // }
    

    
    // loadToken() {
    // this.token = localStorage.getItem('jwt')!;
    // // this.decodeJWT();
    // }

    // getToken(){
    //     return this.token;
    // }
    
    // isTokenExpired(): Boolean {
    //     return  this.helper.isTokenExpired(this.token);   
    // }
    
    
    // registerUser(user :User){
    //     console.log(user);
    //     //return this.http.post<User>(this.apiURL+'/register', user,{observe:'response'});
    // }
    
    
    // validateEmail(code : string){
    //     return this.http.get<User>(this.apiURL+'/verifyEmail/'+code);
    // }

}
