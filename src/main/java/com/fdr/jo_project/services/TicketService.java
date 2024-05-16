package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    Ticket saveTicket(Ticket t);
    Ticket updateTicket(Ticket t);
    void deleteTicket(Ticket t);
    void deleteTicketById(Long id);
    Optional<Ticket> getTicket (Long id);
    List<Ticket> getAllTickets();
}
