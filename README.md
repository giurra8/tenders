# Example API for construction management
This is a bare-bones example of an API for managing construction tenders and offers.

It is built using SpringBoot with Java13 and contains an embedded MongoDB instance, with the basic structure shelled out in the main
`TendersApplication` class. The data produced and consumed is in JSON format.

## Requirements
- [Java 13](https://www.oracle.com/technetwork/java/javase/downloads/jdk13-downloads-5672538.html)
- git
- Maven
## Recommended tools
- [curl](https://curl.haxx.se/download.html)

## Instructions

1. Clone repository via `git clone https://github.com/giurra8/tenders.git`
2. Import as Maven project

TendersApplication should be runnable, and the app should be hosted on port 8080 by default.

## Basic navigation

Please bear in mind that the IDs will change with each app execution due to the embedded, in-memory DB! 

### To fetch all existing offers/tenders/bidders/issuers:
- `curl http://localhost:8080/api/offers/all`
- `curl http://localhost:8080/api/tenders/all`
- `curl http://localhost:8080/api/bidders/all`
- `curl http://localhost:8080/api/issuers/all`