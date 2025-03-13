# best-practices
I am hoping for this repository to serve several purposes
* An example of common Spring Boot integration patterns in terms of setting up 
  * Http Endpoints and Clients (using swagger)
  * Kafka Consumers and producers
  * Databases and Caches
  * etc
* An example of common code design patterns how and why to use them
  * strategy pattern
  * adapter pattern
  * factory pattern
* A place to explain my preferred approaches to things
  * Url-based versioning of APIs
  * Avoid using @Service and @Autowired annotations
  * Use interfaces in constructors (your tests will thank you)

### To Run:

`docker compose up -d`

`mvn clean install && (cd core && mvn spring-boot:run)`

### Swagger UI location: http://localhost:8080/swagger-ui/index.html

## version 0.0.1-SNAPSHOT
Multi-module project setup with kafka listeners and rest endpoints

## version 0.0.2-SNAPSHOT
Utilizing OAS swagger file to generate controllers, and implementing swagger ui

## version 0.0.3-SNAPSHOT
Implement wiremock standalone docker container and utilized to mock external systems

## version 0.0.4-SNAPSHOT
Add @SpringBootTest e2e tests that leverage wiremock embedded server

## version 0.0.5-SNAPSHOT
Update @SpringBootTest e2e tests to leverage testRestTemplate to test endpoints/controllers

## version 0.0.6-SNAPSHOT
Update @SpringBootTest e2e tests to leverage embedded kafka broker
