package com.olmero.tenders.service.impl;

import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.repository.IssuerRepository;
import com.olmero.tenders.service.IssuerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("issuerService")
public class IssuerServiceImpl implements IssuerService {

    private final IssuerRepository repository;

    public IssuerServiceImpl(final IssuerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Issuer> getAllIssuers() {
        return repository.findAll();
    }
}
