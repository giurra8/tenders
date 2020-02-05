package com.olmero.tenders.service;

import com.olmero.tenders.model.tender.Tender;

import java.util.List;

public interface TenderService {

    /**
     * Returns all existing tenders
     * @return existing tenders
     */
    List<Tender> getAllTenders();

    /**
     * Returns all existing tenders from specified issuer
     * @param id issuer id
     * @return existing offers
     */
    List<Tender> getAllTendersFromIssuer(String id);

    /**
     * Returns specified tender
     * @param id tender id
     * @return specified tender
     */
    Tender getTender(String id);

    /**
     * Deletes specified tender
     * @param id tender id
     */
    void deleteTender(String id);

}
