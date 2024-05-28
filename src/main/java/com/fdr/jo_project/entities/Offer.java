package com.fdr.jo_project.entities;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOffer;

    private String type;

    private Double price;


}
