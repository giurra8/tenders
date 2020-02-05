package com.olmero.tenders.model.company;

import com.olmero.tenders.model.common.Company;
import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.utils.Profession;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

public class Bidder extends Company {

    @Getter
    @Setter
    private List<Offer> offerList;

    public Bidder(@NonNull String title, @NonNull Profession profession) {
        super(title, profession);
    }
}
