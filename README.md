# best-practices
a collection of common approaches to software development practices and designs

## version 0.0.1-SNAPSHOT
Multi-module project setup with kafka listeners and rest endpoints

### To Run:

`docker compose up -d`

`mvn clean install && (cd core && mvn spring-boot:run)`

`curl -i http://localhost:8080/sample`

`curl --header "Content-Type: application/json" --request POST --data 'this is the message' http://localhost:8080/sample`

`echo "this is the message" | kafka-console-producer --broker-list "localhost:29092,localhost:39092" --topic "sample-input"`
