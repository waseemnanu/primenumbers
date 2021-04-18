# Get Prime Numbers

This is a Spring Boot application that fetches all the prime numbers upto the number provided in the input (Please make sure to pass the number in the path less than 10000 as this is the upper limit set currently in the code).

## How to Run 

* Clone this repository 
* Make sure you are using JDK 1.8 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar target/primenumbers-0.0.1-SNAPSHOT.jar
        mvn spring-boot:run
```
* Check the stdout to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2021-04-18 13:19:18.296  INFO 23432 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8090 (http) with context path ''
2021-04-18 13:19:18.356  INFO 23432 --- [           main] c.r.p.PrimeNumbersApplication            : Started PrimeNumbersApplication in 3.654 seconds (JVM running for 4.317)
```

## About the Service

The service is just a simple get prime numbers REST service. REST endpoints defined in ```com.rbs.primenumbers.controller.GetPrimeNumbersController``` on **port 8090**. (see below)

Here is the endpoints you can call:

### Retrieve prime numbers in a list

```
http://localhost:8090/primenumbers/10

Response: HTTP 200
Content: [2,3,5,7]
```