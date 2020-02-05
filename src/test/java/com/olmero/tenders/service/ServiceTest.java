package com.olmero.tenders.service;

import com.olmero.tenders.model.tender.Offer;
import com.olmero.tenders.utils.OfferStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OfferService offerService;

    @MockBean
    private TenderService tenderService;

    @MockBean
    private Offer offer;

    @Test
    public void shouldAcceptOffer() {
        when(offerService.acceptOffer(offer.getId())).thenReturn(offer);
    }

    @Test
    public void shouldNotRejectAcceptedOffer() {
        offer.setStatus(OfferStatus.ACCEPTED);
        when(offerService.rejectOffer(offer.getId())).thenThrow(new HttpClientErrorException(HttpStatus.FORBIDDEN));
    }

    @Test
    public void shouldThrowWhenDeletingMissingResource() throws ResourceNotFoundException {
        tenderService.deleteTender("07xd907kleto64iuw908");
    }

}
