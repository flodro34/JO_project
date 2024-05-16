package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{


    TicketRepository ticketRepository;
    @Override
    public Ticket saveTicket(Ticket t) {
        return ticketRepository.save(t);
    }

    @Override
    public Ticket updateTicket(Ticket t) {
        return ticketRepository.save(t);
    }

    @Override
    public void deleteTicket(Ticket t) {
        ticketRepository.delete(t);
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);

    }

    @Override
    public Optional<Ticket> getTicket(Long id) {
        return Optional.of(ticketRepository.findById(id).get());
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
