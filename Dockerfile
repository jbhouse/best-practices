FROM openjdk:21
WORKDIR /
COPY core/target/core-*.jar /best-practices.jar
CMD ["java", "-jar", "-Dspring.config.location=/config-volume/application.properties", "-Dlogging.config=/config-volume/logback.xml", "/best-practices.jar"]
