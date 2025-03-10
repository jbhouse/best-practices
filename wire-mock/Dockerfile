# Sample Dockerfile
FROM wiremock/wiremock:3.12.1
COPY ./src/main/resources /home/wiremock
ENTRYPOINT ["/docker-entrypoint.sh", "--global-response-templating", "--disable-gzip", "--verbose"]
