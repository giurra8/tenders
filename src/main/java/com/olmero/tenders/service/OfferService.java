package com.olmero.tenders.service;

import com.olmero.tenders.error.ApiError;
import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.model.tender.Tender;

import java.util.List;

public interface OfferService {

    List<Offer> getAllOffers();

    List<Offer> getAllOffersForTender(String id);

    List<Offer> getAllOffersFromBidder(String id);

    List<Offer> getAllOffersFromBidderForTender(String bidderId, String tenderId);

    void createOffer(Tender tender);

    Offer acceptOffer(String id) throws ApiError;

    void rejectOffer(String id);

    void rejectAllOffers();

}
