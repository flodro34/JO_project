package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.OfferDTO;
import com.fdr.jo_project.entities.Offer;

import java.util.List;


public interface OfferService {
    OfferDTO saveOffer(OfferDTO o);
    OfferDTO updateOffer(OfferDTO o);

    OfferDTO getOffer (Long id);
    List<OfferDTO> getAllOffers();

    void deleteOffer(Offer o);
    void deleteOfferById(Long id);

    OfferDTO convertEntityToDTO(Offer o);
    Offer convertDTOToEntity(OfferDTO offerDTO);
}
