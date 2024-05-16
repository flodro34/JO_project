package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Offer;

import java.util.List;
import java.util.Optional;

public interface OfferService {
    Offer saveOffer(Offer o);
    Offer updateOffer(Offer o);
    void deleteOffer(Offer o);
    void deleteOfferById(Long id);
    Optional<Offer> getOffer (Long id);
    List<Offer> getAllOffers();
}
