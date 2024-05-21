package com.fdr.jo_project.services;

import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    OfferRepository offerRepository;

    @Override
    public Offer saveOffer(Offer o) {
        return offerRepository.save(o);
    }

    @Override
    public Offer updateOffer(Offer o) {
        return offerRepository.save(o);
    }

    @Override
    public void deleteOffer(Offer o) {
        offerRepository.delete(o);
    }

    @Override
    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Offer getOffer(Long id) {
        return offerRepository.findById(id).get();
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
}
