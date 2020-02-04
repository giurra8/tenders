package com.olmero.tenders;

import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.OfferRepository;
import com.olmero.tenders.repository.TenderRepository;
import com.olmero.tenders.utils.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TendersApplication implements CommandLineRunner {

    private final TenderRepository tenderRepository;

    private final OfferRepository offerRepository;

    public TendersApplication(final TenderRepository tenderRepository, final OfferRepository offerRepository) {
        this.tenderRepository = tenderRepository;
        this.offerRepository = offerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TendersApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Issuer firstIssuer = new Issuer("Spaces", Profession.INVESTOR);
        Issuer secondIssuer = new Issuer("FirstIssue LTD", Profession.INVESTOR);

        Tender firstTender = new Tender();
        Tender secondTender = new Tender();
        Tender thirdTender = new Tender();

        Bidder firstBidder = new Bidder("ProStruct GmbH", Profession.CONTRACTOR);
        Bidder secondBidder = new Bidder("SignStudio", Profession.CONTRACTOR);

        Offer firstOffer = new Offer(firstTender);
        Offer secondOffer = new Offer(secondTender);

        firstTender.setIssuer(firstIssuer);
        secondTender.setIssuer(secondIssuer);
        thirdTender.setIssuer(secondIssuer);

        firstOffer.setBidder(firstBidder);
        secondOffer.setBidder(secondBidder);

        tenderRepository.save(firstTender);
        tenderRepository.save(secondTender);
        tenderRepository.save(thirdTender);

        offerRepository.save(firstOffer);
        offerRepository.save(secondOffer);

    }
}
