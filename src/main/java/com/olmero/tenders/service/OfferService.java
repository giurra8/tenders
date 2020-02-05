package com.olmero.tenders.service;

import com.olmero.tenders.model.tender.Offer;

import java.util.List;

public interface OfferService {

    List<Offer> getAllOffers();

    List<Offer> getAllOffersForTender(String id);

    List<Offer> getAllOffersFromBidder(String id);

    List<Offer> getAllOffersFromBidderForTender(String bidderId, String tenderId);

    Offer acceptOffer(String id);

    void rejectOffer(String id);

    void rejectAllOffers(String tenderId);

}
