package com.fdr.jo_project.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    @OneToOne
    @JoinColumn(name = "idOffer", referencedColumnName = "idOffer")
    private Offer offer;

    private String tokenTicket;

    private String tokenUser;

    private String tokenTransaction;

    @ManyToOne
    @JoinColumn(name = "user_tokenUser", referencedColumnName = "tokenUser")

    private User user;

    public Ticket() {

    }

    public Ticket(Offer offer,String tokenTransaction) {
        this.offer = offer;
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
                ", type of Offer='" + (offer != null ? offer.toString() : "null") +
                ", tokenTicket='" + tokenTicket + '\'' +
                ", tokenUser='" + tokenUser + '\'' +
                ", tokenTransaction='" + tokenTransaction + '\'' +
                ", user=" + (user != null ? user.toString() : "null") +
                '}';
    }

}
