package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
