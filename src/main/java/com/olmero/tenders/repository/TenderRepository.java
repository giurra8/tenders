package com.olmero.tenders.repository;

import com.olmero.tenders.model.tender.Tender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tenders", path = "tenders")
public interface TenderRepository extends MongoRepository<Tender, String> {

}
