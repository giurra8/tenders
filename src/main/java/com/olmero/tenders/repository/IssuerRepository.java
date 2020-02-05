package com.olmero.tenders.repository;

import com.olmero.tenders.model.company.Issuer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "issuers", path = "issuers")
public interface IssuerRepository extends MongoRepository<Issuer, String> {
}
