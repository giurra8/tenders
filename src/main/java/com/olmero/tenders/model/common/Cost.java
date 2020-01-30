package com.olmero.tenders.model.common;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Currency;

public class Cost {

    @Getter
    @Setter
    private BigDecimal amount;

    @Getter
    @Setter
    private Currency currency;

    public Cost(@NonNull BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

}
