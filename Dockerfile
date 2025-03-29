FROM openjdk:21
WORKDIR /
COPY core/target/core-*.jar /best-practices.jar
CMD ["java", "-jar", "-Dspring.config.location=file:./config-volume/application.properties", "/best-practices.jar"]
