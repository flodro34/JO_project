package com.fdr.jo_project.services;

import com.fdr.jo_project.dto.OfferDTO;
import com.fdr.jo_project.dto.TicketDTO;
import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.entities.Ticket;
import com.fdr.jo_project.repositories.OfferRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OfferServiceImpl implements OfferService{

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public OfferDTO saveOffer(OfferDTO o) {

        return convertEntityToDTO(offerRepository.save(convertDTOToEntity(o)));
    }

    @Override
    public OfferDTO updateOffer(OfferDTO o) {

        return convertEntityToDTO(offerRepository.save(convertDTOToEntity(o)));
    }


    @Override
    public OfferDTO getOffer(Long id) {

       return convertEntityToDTO(offerRepository.findById(id).get());
    }

    @Override
    public List<OfferDTO> getAllOffers() {
        return offerRepository.findAll().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
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
    public OfferDTO convertEntityToDTO(Offer o) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        OfferDTO offerDTO = modelMapper.map(o, OfferDTO.class);
        return offerDTO;
    }

    @Override
    public Offer convertDTOToEntity(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer = modelMapper.map(offerDTO, Offer.class);
        return offer;
    }

}
