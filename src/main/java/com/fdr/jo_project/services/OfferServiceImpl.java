package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    OfferService offerService;

    @Override
    public Offer saveOffer(Offer o) {
        return offerService.saveOffer(o);
    }

    @Override
    public Offer updateOffer(Offer o) {
        return offerService.saveOffer(o);
    }

    @Override
    public void deleteOffer(Offer o) {
        offerService.deleteOffer(o);
    }

    @Override
    public void deleteOfferById(Long id) {
        offerService.deleteOfferById(id);
    }

    @Override
    public Offer getOffer(Long id) {
        return offerService.getOffer(id);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }
}
