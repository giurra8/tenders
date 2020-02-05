package com.olmero.tenders.service;

import com.olmero.tenders.model.company.Bidder;

import java.util.List;

public interface BidderService {

    /**
     * Returns all existing bidders
     * @return existing bidders
     */
    List<Bidder> getAllBidders();

}
