package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByTokenUser(String tokenUser);
}
