package com.fdr.jo_project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private String typeOffer;
    private String tokenTicket;

    private String tokenUser;

    private String tokenTransaction;

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getTypeOffer() {
        return typeOffer;
    }

    public void setTypeOffer(String typeOffer) {
        this.typeOffer = typeOffer;
    }

    public String getTokenTicket() {
        return tokenTicket;
    }

    public void setTokenTicket(String tokenTicket) {
        this.tokenTicket = tokenTicket;
    }

    public String getTokenUser() {
        return tokenUser;
    }

    public void setTokenUser(String tokenUser) {
        this.tokenUser = tokenUser;
    }

    public String getTokenTransaction() {
        return tokenTransaction;
    }

    public void setTokenTransaction(String tokenTransaction) {
        this.tokenTransaction = tokenTransaction;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", typeOffer='" + typeOffer + '\'' +
                ", tokenTicket='" + tokenTicket + '\'' +
                ", tokenUser='" + tokenUser + '\'' +
                ", tokenTransaction='" + tokenTransaction + '\'' +
                '}';
    }
}
