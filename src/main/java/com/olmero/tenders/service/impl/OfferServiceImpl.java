package com.olmero.tenders.service.impl;

import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.repository.OfferRepository;
import com.olmero.tenders.service.OfferService;
import com.olmero.tenders.utils.OfferStatus;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service("offerService")
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(final OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> getAllOffersForTender(String id) {
        return offerRepository.findAll().stream()
                .filter(offer -> offer.getTender().getId().equals(id))
                .collect(Collectors.toList());

    }

    @Override
    public List<Offer> getAllOffersFromBidder(String id) {
        return offerRepository.findAll().stream()
                .filter(offer -> offer.getBidder().getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Offer> getAllOffersFromBidderForTender(String bidderId, String tenderId) {
        return offerRepository.findAll().stream()
                .filter(offer -> offer.getBidder().getId().equals(bidderId)
                        && offer.getTender().getId().equals(tenderId))
                .collect(Collectors.toList());
    }

    @Override
    // automatically reject all other competing offers once one is accepted
    public Offer acceptOffer(String id) {
        Offer offer = offerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        offer.setStatus(OfferStatus.ACCEPTED);
        offerRepository.save(offer);
        rejectAllOffers(offer.getTender().getId());
        return offer;
    }

    @Override
    public Offer rejectOffer(String id) {
        Offer offer = offerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (offer.getStatus().equals(OfferStatus.ACCEPTED)) {
            throw new HttpClientErrorException(HttpStatus.FORBIDDEN, "Once an offer is accepted it can no longer be rejected");
        }
        offer.setStatus(OfferStatus.REJECTED);
        offerRepository.save(offer);
        return offer;
    }

    @Override
    public void rejectAllOffers(String tenderId) {
        List<Offer> offers = getAllOffersForTender(tenderId).stream()
                .filter(offer -> offer.getStatus().equals(OfferStatus.PENDING))
                .collect(Collectors.toList());
        // optionally fetch all WITHDRAWN offers as well; just to make sure all existing offers are explicitly rejected
        offers.forEach(offer -> offer.setStatus(OfferStatus.REJECTED));
        offerRepository.saveAll(offers);
    }

}
