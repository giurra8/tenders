package com.olmero.tenders.repository;

import com.olmero.tenders.model.company.Bidder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "bidders", path = "bidders")
public interface BidderRepository extends MongoRepository<Bidder, String> {

}
