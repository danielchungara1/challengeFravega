# Fravega Challenge

### Technologies
* Java 13
* Postgres 13
* Spring Boot 2
* Spring Data JPA
* Spring Web
* Flyway Migrations
* Docker    
* Gradle

### Preconditions
* JDK 13
* Postgres 13
* Database client like DBeaver for database creation
* Docker (is necessary to run the tests)  
* Create postgres database: challengeFravega
* Authentication to postgres server is username: postgres & password: rootroot
* Change application.properties according the current postgres server configuration.

### Compile & Run
* ./gradlew bootRun

### Api documentation per endpoint
#### /api/v1.0/branch-office
* Description: Create a branch office.
* Example Request: POST API/branch-office
* Example Request Json Body:
```json
{
  "attention":  "LU/SA: 10:00 a 18:00hs",
  "location" : {
    "address":  "Av. Corrientes 3889, Capital Federal",
    "latitude": "-11.603001",
    "longitude": "-45.419087"
  }
}
```
* Example Response 200 OK:
```json
{
  "message": "Branch Office created.",
  "details": null,
  "data": {
    "id": 30,
    "attention": "LU/SA: 10:00 a 18:00hs",
    "location": {
      "id": 47,
      "address": "Av. Corrientes 3889, Capital Federal",
      "latitude": -11.603001,
      "longitude": -45.419087
    }
  }
}
```
#### PUT /api/v1.0/branch-office/{id}
#### GET /api/v1.0/branch-office/{id}
#### DELETE /api/v1.0/branch-office/{id}
#### POST /api/v1.0/withdrawal-point
#### PUT /api/v1.0/withdrawal-point/{id}
#### GET /api/v1.0/withdrawal-point/{id}
#### DELETE /api/v1.0/withdrawal-point/{id}

#### GET api/v1.0/location/nearest-location?latitude={qParam1}={qParam2}
* Example localhost:8080/api/v1.0/location/nearest-location?latitude=-7.111984&longitude=-45.419087