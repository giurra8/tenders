package com.olmero.tenders.service.impl;

import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.OfferRepository;
import com.olmero.tenders.service.OfferService;
import com.olmero.tenders.utils.OfferStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("offerService")
public class OfferServiceImpl implements OfferService {

    private final OfferRepository repository;

    public OfferServiceImpl(OfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createOffer(Tender tender) {
        repository.save(new Offer(new Tender()));
    }

    @Override
    public void acceptOffer(String id) {
        Offer offer = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        offer.setStatus(OfferStatus.ACCEPTED);
        repository.save(offer);
        rejectAllOffers();
    }

    @Override
    public void rejectOffer(String id) {

    }

    @Override
    public void rejectAllOffers() {
       List<Offer> offers = repository.findAllByStatus(OfferStatus.PENDING);
       for (Offer o : offers) {
           o.setStatus(OfferStatus.REJECTED);
       }
       repository.saveAll(offers);
    }

}
