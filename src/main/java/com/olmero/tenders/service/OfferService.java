package com.olmero.tenders.service;

import com.olmero.tenders.model.tender.Tender;

public interface OfferService {

    void createOffer(Tender tender);

    void acceptOffer(String id);

    void rejectOffer(String id);

    void rejectAllOffers();

}
