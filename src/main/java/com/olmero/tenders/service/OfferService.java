package com.olmero.tenders.service;

import com.olmero.tenders.model.tender.Offer;

import java.util.List;

public interface OfferService {

    /**
     * Returns all existing offers
     * @return existing offers
     */
    List<Offer> getAllOffers();

    /**
     * Returns all existing offers for a specified tender
     * @param id tender id
     * @return existing offers
     */
    List<Offer> getAllOffersForTender(String id);

    /**
     * Returns all existing offers from a specified bidder
     * @param id bidder id
     * @return existing offers
     */
    List<Offer> getAllOffersFromBidder(String id);

    /**
     * Returns all existing offers from a specified bidder for a specified tender
     * @param bidderId bidder id
     * @param tenderId tender id
     * @return existing offers
     */
    List<Offer> getAllOffersFromBidderForTender(String bidderId, String tenderId);

    /**
     * Accepts specified offer and changes its status to ACCEPTED
     * @param id offer id
     * @return accepted offer
     */
    Offer acceptOffer(String id);

    /**
     * Rejects specified offer and changes its status to REJECTED
     * @param id offer id
     * @return rejected offer
     */
    Offer rejectOffer(String id);

    /**
     * Rejects all remaining offers for the specified tender
     * @param tenderId tender id
     */
    void rejectAllOffers(String tenderId);

}
