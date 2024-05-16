package com.fdr.jo_project.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    private Long idOffer;

    private String tokenTicket;

    private String tokenUser;

    private String tokenTransaction;

    @ManyToOne
    @JoinColumn(name = "user_tokenUser", referencedColumnName = "tokenUser")

    private User user;

    public Ticket() {

    }

    public Ticket(long idOffer,String tokenTransaction) {
        this.idOffer = idOffer;
        this.tokenTransaction = tokenTransaction;
    }

    @PrePersist
    @PreUpdate
    private void prepareData() {
        if (user != null) {
            this.tokenUser = user.getTokenUser();
        }
        this.tokenTicket = generateTokenTicket();
    }

    private String generateTokenTicket() {
        return tokenUser + "-" + tokenTransaction;
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", type of Offer='" + idOffer + '\'' +
                ", tokenTicket='" + tokenTicket + '\'' +
                ", tokenUser='" + tokenUser + '\'' +
                ", tokenTransaction='" + tokenTransaction + '\'' +
                ", user=" + (user != null ? user.toString() : "null") +
                '}';
    }

}
