package com.olmero.tenders.service.impl;

import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.repository.BidderRepository;
import com.olmero.tenders.service.BidderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bidderService")
public class BidderServiceImpl implements BidderService {

    private final BidderRepository repository;

    public BidderServiceImpl(final BidderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Bidder> getAllBidders() {
        return repository.findAll();
    }
}
