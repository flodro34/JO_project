package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.TicketDTO;
import com.fdr.jo_project.entities.Ticket;

import java.util.List;

public interface TicketService {
    TicketDTO saveTicket(TicketDTO t);
    TicketDTO updateTicket(TicketDTO t);

    TicketDTO getTicket (Long id);
    List<TicketDTO> getAllTickets();


    void deleteTicket(Ticket t);
    void deleteTicketById(Long id);

    List<Ticket> findByTokenUser(String tokenUser);
    List<Ticket> findByUserIdUser(Long id);

    TicketDTO convertEntityToDTO(Ticket t);
    Ticket convertDTOToEntity(TicketDTO ticketDTO);
}
