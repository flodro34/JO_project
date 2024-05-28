package com.fdr.jo_project.controllers;

import com.fdr.jo_project.dto.OfferDTO;
import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offer")
@CrossOrigin
public class OfferController {

    @Autowired
    OfferService offerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OfferDTO> getAllOffers(){
        return offerService.getAllOffers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public OfferDTO getOfferById(@PathVariable("id") Long id){
        return offerService.getOffer(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public OfferDTO createTicket(@RequestBody OfferDTO offerDTO){
        return offerService.saveOffer(offerDTO);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public OfferDTO updateTicket(@RequestBody OfferDTO offerDTO){
        return offerService.updateOffer(offerDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOffer(@PathVariable("id") Long id){
        offerService.deleteOfferById(id);
    }

}
