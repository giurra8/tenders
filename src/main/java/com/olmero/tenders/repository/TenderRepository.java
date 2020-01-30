package com.olmero.tenders.repository;

import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.model.tender.Tender;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tenders", path = "tenders")
public interface TenderRepository extends MongoRepository<Tender, String> {

    List<Tender> findByIssuer(@Param("title") Issuer issuer);

}
