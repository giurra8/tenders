package com.olmero.tenders.service;

import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.model.tender.Tender;

import java.util.List;

public interface TenderService {

    List<Tender> getAllTenders();

    List<Tender> getAllTendersFromIssuer(String id);

    Tender getTender(String id);

    void deleteTender(String id);

}
