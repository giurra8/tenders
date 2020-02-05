package com.olmero.tenders.utils;

// newly created tenders are labelled as 'OPEN'
// could also be used to distinguish 'biddable' tenders - e.g. only open ones can accept offers
// TODO label tender as 'CLOSED' once an offer is accepted?
public enum TenderStatus {

    OPEN,
    CLOSED,
    CANCELLED

}
