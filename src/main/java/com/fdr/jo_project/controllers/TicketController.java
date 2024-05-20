package com.fdr.jo_project.controllers;

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
@RequestMapping("/api")
@CrossOrigin
public class TicketController {

    @Autowired
    TicketService ticketService;

//    @Autowired
//    UserService userService;


//    @PostMapping("/tickets")
//    public ResponseEntity<?> createTicket(@RequestBody Ticket ticketData, HttpSession session) {
//        String tokenUser = (String) session.getAttribute("tokenUser"); // Récup tokenUser de la session
//        if (tokenUser == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User must be logged in to create a ticket");
//        }
//
//        if (!userService.isValidTokenUser(tokenUser)) {
//            return ResponseEntity.badRequest().body("Invalid user token");
//        }
//
//        ticketData.setTokenUser(tokenUser);
//        ticketData.setTokenTicket(ticketData.getTokenUser() + "-" + ticketData.getTokenTransaction());
//        Ticket savedTicket = ticketService.saveTicket(ticketData);
//        return ResponseEntity.ok(savedTicket);
//    }

//    @GetMapping("/tickets")
//    public ResponseEntity<?> getAllTicketsByTokenUser(HttpSession session) {
//        String tokenUser = (String) session.getAttribute("tokenUser");
//        if (tokenUser == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User must be logged in to view tickets");
//        }
//
//        if (!userService.isValidTokenUser(tokenUser)) {
//            return ResponseEntity.badRequest().body("Invalid user token");
//        }
//
//        List<Ticket> tickets = ticketService.findByTokenUser(tokenUser);
//        return ResponseEntity.ok(tickets);
//    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Ticket getTicketById(@PathVariable("id") Long id){
        return ticketService.getTicket(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketService.saveTicket(ticket);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Ticket updateTicket(@RequestBody Ticket ticket){
        return ticketService.updateTicket(ticket);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTicket(@PathVariable("id") Long id){
        ticketService.deleteTicketById(id);
    }

    @RequestMapping(value = "/userTicket/{idUser}", method = RequestMethod.GET)
    public List<Ticket> getTicketByUserId(@PathVariable("idUser") Long idUser){
        return ticketService.findByUserIdUser(idUser);
    }

}
