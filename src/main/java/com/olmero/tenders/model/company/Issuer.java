package com.olmero.tenders.model.company;

import com.olmero.tenders.model.common.Company;
import com.olmero.tenders.utils.Profession;
import lombok.NonNull;

public class Issuer extends Company {

    public Issuer(@NonNull String title, @NonNull Profession profession) {
        super(title, profession);
    }
}
