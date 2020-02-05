package com.olmero.tenders.service.impl;

import com.olmero.tenders.error.ApiError;
import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.OfferRepository;
import com.olmero.tenders.repository.TenderRepository;
import com.olmero.tenders.service.OfferService;
import com.olmero.tenders.utils.OfferStatus;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("offerService")
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final TenderRepository tenderRepository;

    public OfferServiceImpl(final OfferRepository offerRepository, final TenderRepository tenderRepository) {
        this.offerRepository = offerRepository;
        this.tenderRepository = tenderRepository;
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
    public void createOffer(Tender tender) {
        offerRepository.save(new Offer(tender));
    }

    @Override
    public Offer acceptOffer(String id) {
//        Offer offer = offerRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
//        if (offer.getStatus().equals(OfferStatus.ACCEPTED)) {
//            throw new ApiError(HttpStatus.FORBIDDEN, "Once an offer is accepted it cannot be rejected.");
//        }
//        offer.setStatus(OfferStatus.ACCEPTED);
//        offerRepository.save(offer);
//        rejectAllOffers();
//        return offer;
        return null;
    }

    @Override
    public void rejectOffer(String id) {

    }

    @Override
    public void rejectAllOffers() {
        List<Offer> offers = offerRepository.findAllByStatus(OfferStatus.PENDING);
        // optional; just to make sure all existing offers are explicitly rejected
        // offers.addAll(repository.findAllByStatus(OfferStatus.WITHDRAWN));
        offers.forEach(offer -> offer.setStatus(OfferStatus.REJECTED));
        offerRepository.saveAll(offers);
    }

}
