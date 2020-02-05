package com.olmero.tenders.service;

import com.olmero.tenders.model.company.Issuer;

import java.util.List;

public interface IssuerService {

    /**
     * Returns all existing issuers
     * @return existing issuers
     */
    List<Issuer> getAllIssuers();

}
