package com.olmero.tenders.controller;

import com.olmero.tenders.model.company.Bidder;
import com.olmero.tenders.service.BidderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bidders")
public class BidderController {

    private final BidderService service;

    public BidderController(final BidderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Bidder> getAllBidders() {
        return service.getAllBidders();
    }

}
