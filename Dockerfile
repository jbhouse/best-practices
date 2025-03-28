FROM openjdk:21
WORKDIR /app
COPY core/target/core-*.jar /app/best-practices.jar
CMD ["java", "-jar", "/app/best-practices.jar"]
