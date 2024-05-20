package com.fdr.jo_project;

import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.entities.User;
import com.fdr.jo_project.repositories.TicketRepository;
import com.fdr.jo_project.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JoProjectApplicationTests {

    @Autowired
    private TicketRepository ticketRepository;
    @Test
    public void testCreateTicket(){
        Ticket ticket = new Ticket();

        ticketRepository.save(ticket);
    }
    @Test
    public void testFindTicket()
    {
        Ticket t = ticketRepository.findById(1L).get();
        System.out.println(t);
    }

//    @Test
//    public void testUpdateTicket()
//    {
//        Ticket t = ticketRepository.findById(1L).get();
//        t.setTypeOffer("Duo");
//        ticketRepository.save(t);
//    }

    @Test
    public void testDeleteTicket()
    {
        ticketRepository.deleteById(1L);
    }
    @Test
    public void testGetAllTickets()
    {
        List<Ticket> tickets = ticketRepository.findAll();
        for (Ticket t : tickets)
        {
            System.out.println(t);
        }
    }



}
