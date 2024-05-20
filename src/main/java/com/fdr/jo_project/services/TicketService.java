package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Ticket;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(Ticket t);
    Ticket updateTicket(Ticket t);
    void deleteTicket(Ticket t);
    void deleteTicketById(Long id);
    Ticket getTicket (Long id);
    List<Ticket> getAllTickets();

    List<Ticket> findByTokenUser(String tokenUser);

    List<Ticket> findByUserIdUser(Long id);
}
