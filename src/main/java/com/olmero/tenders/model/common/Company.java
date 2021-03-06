package com.olmero.tenders.model.common;

import com.olmero.tenders.utils.Profession;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public abstract class Company {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String contactPerson;

    @Getter
    @Setter
    private Address address;

    @Getter
    @Setter
    private Profession profession;

    public Company(@NonNull String title, @NonNull Profession profession) {
        this.title = title;
        this.profession = profession;
    }

}
