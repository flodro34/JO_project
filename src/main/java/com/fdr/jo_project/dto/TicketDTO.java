package com.fdr.jo_project.dto;

import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {

    private Long idTicket;
    private Offer typeOffer;
    private Date date;
    private String tokenTicket;
    private String tokenUser;
    private String tokenTransaction;
    private User user;
}
