package com.olmero.tenders.service.impl;

import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.TenderRepository;
import com.olmero.tenders.service.TenderService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("tenderService")
public class TenderServiceImpl implements TenderService {

    private final TenderRepository repository;

    public TenderServiceImpl(final TenderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Tender> getAllTenders() {
        return repository.findAll();
    }

    @Override
    public List<Tender> getAllTendersFromIssuer(String id) {
        return repository.findAll().stream()
                .filter(tender -> tender.getIssuer().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public Tender getTender(String id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteTender(String id) {
        repository.delete(repository.findById(id).orElseThrow((ResourceNotFoundException::new)));
    }
}
