export class User {
    idUser!: number;
    username!: string;
    firstname!: string;
    lastname!: string;
    email!: string;
    password!: string;
    tokenUser!: string;
    isAdmin?: boolean = false;
    enabled?: boolean = false;

}