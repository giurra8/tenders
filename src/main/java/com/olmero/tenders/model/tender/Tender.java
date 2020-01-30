package com.olmero.tenders.model.tender;

import com.olmero.tenders.model.common.Cost;
import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.utils.TenderStatus;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

public class Tender {

    @Id
    private String id;

    @Getter
    @Setter
    private Issuer issuer;

    @Getter
    @Setter
    private String location;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Cost cost;

    @Getter
    @Setter
    private LocalDate completionDate;

    @Getter
    @Setter
    private LocalDate bidClosingDate;

    @Getter
    @Setter
    private String additionalInfo;

    @Getter
    @Setter
    private TenderStatus status;

    @Getter
    @Setter
    private List<Offer> offerList;

    public Tender(@NonNull Issuer issuer, @NonNull Cost cost) {
        this.issuer = issuer;
        this.cost = cost;
        this.status = TenderStatus.OPEN;
    }

}