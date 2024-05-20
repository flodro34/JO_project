package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
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
    public Ticket getTicket(Long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findByTokenUser(String tokenUser) {
        return ticketRepository.findByTokenUser(tokenUser);
    }

    @Override
    public List<Ticket> findByUserIdUser(Long id) {
        return ticketRepository.findByUserIdUser(id);
    }
}
