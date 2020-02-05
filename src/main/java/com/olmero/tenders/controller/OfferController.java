package com.olmero.tenders.controller;

import com.olmero.tenders.error.ApiError;
import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.service.OfferService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService service;

    public OfferController(final OfferService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Offer> getAllOffers() {
        return service.getAllOffers();
    }

    @RequestMapping(value = "/forTender/{id}", method = RequestMethod.GET)
    public List<Offer> getAllOffersForTender(@PathVariable("id") String id) {
        return service.getAllOffersForTender(id);
    }

    @RequestMapping(value = "/fromBidder/{id}", method = RequestMethod.GET)
    public List<Offer> getAllOffersFromBidder(@PathVariable("id") String id) {
        return service.getAllOffersFromBidder(id);
    }

    @RequestMapping(value = "/fromBidder/{bidderId}/forTender/{tenderId}", method = RequestMethod.GET)
    public List<Offer> getAllOffersFromBidderForTender(
            @PathVariable("bidderId") String bidderId,
            @PathVariable("tenderId") String tenderId) {
        return service.getAllOffersFromBidderForTender(bidderId, tenderId);
    }

    @RequestMapping(value = "/accept/{id}", method = RequestMethod.POST)
    public Offer acceptOffer(@PathVariable("id") String id) throws ApiError {
        return service.acceptOffer(id);
    }

}
