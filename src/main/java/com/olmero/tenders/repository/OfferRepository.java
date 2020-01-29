package com.olmero.tenders.repository;

import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.model.tender.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "offers", path = "offers")
public interface OfferRepository extends MongoRepository<Offer, String> {

    List<Offer> findByBidder(@Param("title") Bidder bidder);

}
