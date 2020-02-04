package com.olmero.tenders.controller;

import com.olmero.tenders.model.tender.Tender;
import com.olmero.tenders.service.TenderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenders")
public class TenderController {

    private final TenderService service;

    public TenderController(final TenderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tender> getAllTenders() {
        return service.getAllTenders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tender getTender(@PathVariable("id") String id) {
        return service.getTender(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTender(@PathVariable("id") String id) {
        service.deleteTender(id);
    }

    @RequestMapping(value = "/issuedBy/{title}", method = RequestMethod.GET)
    public List<Tender> getAllTendersFromIssuer(@PathVariable("title") String title) {
        return service.getAllTendersFromIssuer(title);
    }

}
