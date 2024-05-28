import { Offer } from './offer.model';
import { Transaction } from './transaction.model';
import { User } from './user.model';

export class Ticket {

    idTicket! : number;
    typeOffer! : Offer;
    date! : Date ;
    tokenTicket!: string;
    tokenUser!: User["tokenUser"];
    tokenTransaction!: Transaction["tokenTransaction"];

    constructor() {
        if (this.tokenUser && this.tokenTransaction) {
            this.tokenTicket = this.tokenUser + this.tokenTransaction;
        }
    }
}


