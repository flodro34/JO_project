package com.fdr.jo_project.controllers;

import com.fdr.jo_project.entities.Offer;
import com.fdr.jo_project.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OfferController {

    @Autowired
    OfferService offerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Offer> getAllOffers(){
        return offerService.getAllOffers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Offer getOfferById(@PathVariable("id") Long id){
        return offerService.getOffer(id);
    }

    //Méthode pour test
    @RequestMapping(method = RequestMethod.POST)
    public Offer createTicket(@RequestBody Offer offer){
        return offerService.saveOffer(offer);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Offer updateTicket(@RequestBody Offer offer){
        return offerService.updateOffer(offer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOffer(@PathVariable("id") Long id){
        offerService.deleteOfferById(id);
    }

}
