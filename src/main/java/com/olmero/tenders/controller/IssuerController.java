package com.olmero.tenders.controller;

import com.olmero.tenders.model.company.Issuer;
import com.olmero.tenders.service.IssuerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/issuers")
public class IssuerController {

    private final IssuerService service;

    public IssuerController(final IssuerService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Issuer> getAllIssuers() {
        return service.getAllIssuers();
    }

}
