package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Offer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OfferService {
    Offer saveOffer(Offer o);
    Offer updateOffer(Offer o);
    void deleteOffer(Offer o);
    void deleteOfferById(Long id);
    Offer getOffer (Long id);
    List<Offer> getAllOffers();
}
