I enjoy using wiremock to mock external dependencies/apis

There are two main approaches to this that I currently prefer

1: standalone wiremock mappings
* pros
  * easy deployment of standalone wiremock server which contains all mappings
  * does not rely on having OAS file from other systems/apis
* cons
  * need to maintain mocks and clients separately, causing duplication of effort
  * external api may change without knowledge (should not happen... but...)

2: generate wiremock server from OAS file
* pros
  * generate client to interact with api, and the mock server for it 
  * guaranteed consistency/compatibility, no duplication of effort
* cons
  * requires external teams to provide you with meaningful and correct OAS file
  * more effort to set up independently deployable wiremock server?

For now I will be favoring approach #1 and providing examples of
* setting up independent wiremock server, with Docker
* utilizing embedded wiremock server and mappings for integration tests
