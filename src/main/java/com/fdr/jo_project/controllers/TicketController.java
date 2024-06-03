package com.fdr.jo_project.controllers;

import com.fdr.jo_project.dto.TicketDTO;
import com.fdr.jo_project.services.TicketService;
import com.fdr.jo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.repositories.TicketRepository;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin("*")
public class TicketController {

    @Autowired
    TicketService ticketService;


    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<TicketDTO> getAllTickets(){
        return ticketService.getAllTickets();
    }

    //@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public TicketDTO getTicketById(@PathVariable("id") Long id){
        return ticketService.getTicket(id);
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDTO){
        return ticketService.saveTicket(ticketDTO);
    }

    //@RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public TicketDTO updateTicket(@RequestBody TicketDTO ticketDTO){
        return ticketService.updateTicket(ticketDTO);
    }

    //@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicketById(id);
    }

    //@RequestMapping(value = "/userTicket/{idUser}", method = RequestMethod.GET)
    @GetMapping("/ticket/user/{idUser}")
    public List<Ticket> getAllByUserId(@PathVariable("idUser") Long idUser){
        return ticketService.findByUser(idUser);
    }

    @GetMapping("/user/{tokenUser}")
    public ResponseEntity<List<TicketDTO>> getAllTicketsByTokenUser(@PathVariable("tokenUser") String tokenUser) {
        List<TicketDTO> tickets = ticketService.getAllTicketsByTokenUser(tokenUser);
        return ResponseEntity.ok(tickets);
    }




}
