package com.fdr.jo_project.controllers;

import com.fdr.jo_project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.repositories.TicketRepository;
import jakarta.servlet.http.HttpSession;

import java.util.List;

@RestController
public class TicketController {


    private UserService userService;
    private TicketRepository ticketRepository;

    @PostMapping("/tickets")
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticketData, HttpSession session) {
        String tokenUser = (String) session.getAttribute("tokenUser"); // Récup tokenUser de la session
        if (tokenUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User must be logged in to create a ticket");
        }

        if (!userService.isValidTokenUser(tokenUser)) {
            return ResponseEntity.badRequest().body("Invalid user token");
        }

        ticketData.setTokenUser(tokenUser);
        ticketData.setTokenTicket(ticketData.getTokenUser() + "-" + ticketData.getTokenTransaction());
        Ticket savedTicket = ticketRepository.save(ticketData);
        return ResponseEntity.ok(savedTicket);
    }

    @GetMapping("/tickets")
    public ResponseEntity<?> getAllTicketsByTokenUser(HttpSession session) {
        String tokenUser = (String) session.getAttribute("tokenUser");
        if (tokenUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User must be logged in to view tickets");
        }

        if (!userService.isValidTokenUser(tokenUser)) {
            return ResponseEntity.badRequest().body("Invalid user token");
        }

        List<Ticket> tickets = ticketRepository.findByTokenUser(tokenUser);
        return ResponseEntity.ok(tickets);
    }



}
