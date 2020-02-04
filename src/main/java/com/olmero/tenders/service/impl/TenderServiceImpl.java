package com.olmero.tenders.service.impl;

import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.TenderRepository;
import com.olmero.tenders.service.TenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("tenderService")
public class TenderServiceImpl implements TenderService {

    @Autowired
    private TenderRepository repository;

    @Override
    public void createTender(Tender tender) {
        repository.save(tender);
    }

    @Override
    public List<Tender> getAllTenders() {
        return repository.findAll();
    }

    @Override
    public List<Tender> getAllTendersFromIssuer(String title) {
        return repository.findAll().stream()
                .filter(tender -> tender.getIssuer().getTitle().equals(title))
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
