package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long > {
}
