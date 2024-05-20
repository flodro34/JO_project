package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource(path = "ticket")
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByTokenUser(String tokenUser);

    List<Ticket> findByUserIdUser(Long id);
}
