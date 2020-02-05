# Example API for construction management
This is a bare-bones example of an API for managing construction tenders and offers.

It is built using SpringBoot with Java13 and contains an embedded MongoDB instance, with the basic (mock data) structure
 shelled out in the main
`TendersApplication` class. The data produced and consumed is in JSON format.

## Requirements
- [Java 13](https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html)
- git
- Maven
## Tools used for testing
- [curl](https://curl.haxx.se/download.html)
- alternatively [Postman](https://www.postman.com/downloads/)

## Instructions

1. Clone repository via `git clone https://github.com/giurra8/tenders.git`
2. Import as Maven project

`TendersApplication` should be runnable, and the app should be hosted on port 8080 by default.

## Basic navigation and features

Please bear in mind that the IDs will change with each app execution due to the embedded, in-memory DB.

### To fetch all existing offers/tenders/bidders/issuers:
- `curl http://localhost:8080/api/offers/all`
- `curl http://localhost:8080/api/tenders/all`
- `curl http://localhost:8080/api/bidders/all`
- `curl http://localhost:8080/api/issuers/all`

### Fetch all tenders by specified issuer
- `curl http://localhost:8080/api/tenders/issuedBy/{issuerId}`
### Fetch all offers for specified tender
- `curl http://localhost:8080/api/offers/forTender/{tenderId}`
### Fetch all offers from specified bidder
- `curl http://localhost:8080/api/offers/fromBidder/{bidderId}`
### Fetch all offers from specified bidder for specified tender
- `curl http://localhost:8080/api/offers/fromBidder/{bidderId}/forTender/{tenderId}`
### Accept specified offer - will automatically reject all others
- `curl -X POST http://localhost:8080/api/offers/accept/{id}`
### Reject specified offer - will not allow rejection of previously accepted offer
- `curl -X POST http://localhost:8080/api/offers/reject/{id}`