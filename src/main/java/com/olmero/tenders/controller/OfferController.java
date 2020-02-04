package com.olmero.tenders.controller;

import com.olmero.tenders.service.OfferService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class OfferController {

    private final OfferService service;

    public OfferController(final OfferService service) {
        this.service = service;
    }

}
