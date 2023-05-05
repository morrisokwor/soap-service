FROM openjdk:17-oracle
RUN mkdir /app
WORKDIR /app
COPY target/soap-service-0.0.1-SNAPSHOT.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/soap-service-0.0.1-SNAPSHOT.jar"]