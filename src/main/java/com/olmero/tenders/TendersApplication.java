package com.olmero.tenders;

import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.BidderRepository;
import com.olmero.tenders.repository.IssuerRepository;
import com.olmero.tenders.repository.OfferRepository;
import com.olmero.tenders.repository.TenderRepository;
import com.olmero.tenders.utils.Profession;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TendersApplication implements CommandLineRunner {

    private final TenderRepository tenderRepository;
    private final OfferRepository offerRepository;
    private final BidderRepository bidderRepository;
    private final IssuerRepository issuerRepository;

    public TendersApplication(final TenderRepository tenderRepository, final OfferRepository offerRepository,
                              final BidderRepository bidderRepository, final IssuerRepository issuerRepository) {
        this.tenderRepository = tenderRepository;
        this.offerRepository = offerRepository;
        this.bidderRepository = bidderRepository;
        this.issuerRepository = issuerRepository;
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
        Offer thirdOffer = new Offer(firstTender);
        Offer fourthOffer = new Offer(firstTender);

        firstTender.setIssuer(firstIssuer);
        secondTender.setIssuer(secondIssuer);
        thirdTender.setIssuer(secondIssuer);

        firstOffer.setBidder(firstBidder);
        secondOffer.setBidder(secondBidder);
        thirdOffer.setBidder(secondBidder);
        fourthOffer.setBidder(secondBidder);

//        firstTender.getOfferList().add(firstOffer);
//        firstTender.getOfferList().add(thirdOffer);
//        secondTender.getOfferList().add(secondOffer);

        bidderRepository.save(firstBidder);
        bidderRepository.save(secondBidder);

        issuerRepository.save(firstIssuer);
        issuerRepository.save(secondIssuer);

        tenderRepository.save(firstTender);
        tenderRepository.save(secondTender);
        tenderRepository.save(thirdTender);

        offerRepository.save(firstOffer);
        offerRepository.save(secondOffer);
        offerRepository.save(thirdOffer);
        offerRepository.save(fourthOffer);

    }
}
