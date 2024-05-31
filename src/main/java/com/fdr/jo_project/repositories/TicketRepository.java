package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByTokenUser(String tokenUser);

    List<Ticket> findByUserIdUser(Long id);

    List<Ticket> findByOffer(Offer offer);


}
