# Refactoring report

# Technologies
- Java 8;
- Junit 4.5;
- Commons-io Junit 2.6;


### To run the application just follow the steps below.
- 1 - Enter the folder where the project jar is
- 2 - Execute the following command by cmd
- 3 - java -jar refactoring-report-test-0.0.1-SNAPSHOT.jar --spring.config.location = file: C: /Config/application.yml


### Solution Architecture Based on Circuit Breaker
![Captura de Tela 2019-05-12 às 15 18 49](https://res.cloudinary.com/drc5ukr93/image/upload/v1725575533/q11utyqc1rey1u3swuue.png)

### About this Architecture

Circuit Breaker is a design pattern commonly used in software development to manage failures in distributed systems, 
especially in microservices architectures. The Circuit Breaker pattern prevents a system from making requests to a 
service that is likely to fail, avoiding overloading that service and further propagating failures.

Here’s how it works:

Key Components of the Circuit Breaker Pattern

Closed State:
When the circuit is Closed, the application sends requests to the service as usual.
If the requests are successful, the system continues without issues.
Failures are monitored, and if they exceed a defined threshold, the circuit opens.

Open State:
When the circuit is Open, the application stops sending requests to the failing service.
This prevents overwhelming the service with additional requests while it is down.
During this state, the system may return an error or a fallback response.

Half-Open State:
After a specified period, the circuit moves to Half-Open.
In this state, the system allows a few requests to pass through to the service to test if it has recovered.
If the test requests are successful, the circuit returns to Closed. If they fail, the circuit goes back to Open.