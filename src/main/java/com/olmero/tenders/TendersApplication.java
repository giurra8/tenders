package com.olmero.tenders;

import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.model.common.Cost;
import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.repository.OfferRepository;
import com.olmero.tenders.repository.TenderRepository;
import com.olmero.tenders.utils.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

@SpringBootApplication
public class TendersApplication implements CommandLineRunner {

    @Autowired
    private TenderRepository tenderRepository;

    @Autowired
    private OfferRepository offerRepository;

    public static void main(String[] args) {
        SpringApplication.run(TendersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Issuer firstIssuer = new Issuer("OG Issuer", Profession.INVESTOR);
        Issuer secondIssuer = new Issuer("FirstIssue LTD", Profession.INVESTOR);

        Tender firstTender = new Tender(firstIssuer, new Cost(new BigDecimal(500000), Currency.getInstance("CHF")));
        Tender secondTender = new Tender(secondIssuer, new Cost(new BigDecimal(1200000), Currency.getInstance("EUR")));

        Bidder firstBidder = new Bidder("ProStruct GmbH", Profession.CONTRACTOR);
        Bidder secondBidder = new Bidder("SSG Studio", Profession.CONTRACTOR);

        tenderRepository.save(firstTender);
        tenderRepository.save(secondTender);

    }
}
