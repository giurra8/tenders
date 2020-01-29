package com.olmero.tenders.model.tender;

import com.olmero.tenders.model.common.Cost;
import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.utils.OfferStatus;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Offer {

    @Id
    private String id;

    @Getter
    @Setter
    private Bidder bidder;

    @Getter
    @Setter
    private Tender tender;

    @Getter
    @Setter
    private String proposal;

    @Getter
    @Setter
    private Cost estimatedCost;

    @Getter
    @Setter
    private LocalDate estimatedCompletionTime;

    @Getter
    @Setter
    private String additionalComments;

    @Getter
    @Setter
    private OfferStatus status;

    public Offer(@NonNull Bidder bidder, @NonNull Tender tender, @NonNull Cost estimatedCost, @NonNull LocalDate estimatedCompletionTime) {
        this.bidder = bidder;
        this.tender = tender;
        this.estimatedCost = estimatedCost;
        this.estimatedCompletionTime = estimatedCompletionTime;
        this.status = OfferStatus.PENDING;
    }

}
