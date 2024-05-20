package com.fdr.jo_project.repositories;

import com.fdr.jo_project.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "offer")
public interface OfferRepository extends JpaRepository<Offer, Long > {
}
