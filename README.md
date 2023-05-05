
# SOAP service with java

This is a sample project for showcasing how to create a SOAP service.

## Run Locally

Prerequisites:

    i) Java 17
    ii) Postgres database 

Clone the project

```bash
  https://github.com/morrisokwor/soap-service.git
```

Go to the project directory

```bash
  cd soap-service
```

Install dependencies

```bash
  mvn install
```

Start the application

```bash
  mvn spring-boot:run
```


## Run using Docker

Prerequisites:

    i) Docker
    ii) Docker Compose 

Clone the project

```bash
  https://github.com/morrisokwor/soap-service.git
```

Go to the project directory

```bash
  cd soap-service
```

Download Images by running

```bash
  docker-compose up
```
## Running Tests

To run tests, place the below url on the browser to get the WSDL

```bash
  http://localhost:8080/ws/soap.wsdl
```

Then Import the WSDL on SoapUI tool to for testing.
