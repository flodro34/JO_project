package com.fdr.jo_project.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


import java.util.List;

@Getter
@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idUser;
    protected String lastname;
    protected String firstname;
    protected String email;
    protected String password;
    @Column(unique = true)
    protected String tokenUser;
    protected boolean isAdmin;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    public User() {
        super();
        this.isAdmin = false;
    }

    public User(String lastname, String firstname, String email, String password, String tokenUser, List<Ticket> tickets) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.password = password;
        this.tokenUser = tokenUser;
        this.tickets = tickets;
        this.isAdmin = false;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tokenUser='" + tokenUser + '\'' +
                '}';
    }
}
