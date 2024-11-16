# Spring Cloud Microservices Intro Practice
This project demonstrates a microservices architecture using Spring Cloud and Eureka for service discovery and registration.

## Components
### Eureka Server
- EurekaServerApplication: Acts as the service registry where all microservices register themselves.
- Configuration:
```
spring.application.name=EurekaServer
server.port=8081
eureka.client.service-url.defaultZone=http://localhost:8081/eureka
eureka.client.fetch-registry=false
eureka.client.register-with-eureka=false
```
### SpringCloudTut3 Service
- SpringCloudTut3Application: A Eureka client that registers with the Eureka server.
- SpringCloudTut3RestController: Provides a /helloWorld endpoint.
- Configuration:
```
spring.application.name=SpringCloudTut3
server.port=8083
eureka.client.service-url.defaultZone=http://localhost:8081/eureka
eureka.client.fetch-registry=true
eureka.client.register-with-eureka=true
```
### SpringCloudTut2 Service
- SpringCloudTut2Application: Another Eureka client that registers with the Eureka server.
- Configuration:
```
spring.application.name=SpringCloudTut2Service
server.port=8082
eureka.client.service-url.defaultZone=http://localhost:8081/eureka
eureka.client.fetch-registry=true
eureka.client.register-with-eureka=true
```
### SpringCloudTut4 Service
- SpringCloudTut4Application: Yet another Eureka client that registers with the Eureka server.
- SpringCloudTut4RestController: Uses DiscoveryClient to find instances of SpringCloudTut3Service and call its /helloWorld endpoint.
- Configuration:
```
spring.application.name=SpringCloudTut4Service
server.port=8084
eureka.client.service-url.defaultZone=http://localhost:8081/eureka
eureka.client.fetch-registry=true
eureka.client.register-with-eureka=true
```
## How It Works
#### Service Registration: 
Each microservice registers with the Eureka server on startup.
#### Service Discovery: 
Microservices use DiscoveryClient to discover and communicate with each other dynamically.
#### Inter-Service Communication: 
SpringCloudTut4RestController in SpringCloudTut4Service calls the /helloWorld endpoint of SpringCloudTut3Service using the discovered service instance.

## Running the Project
- Start the Eureka server (EurekaServerApplication).
- Start each microservice (SpringCloudTut3ServiceApplication, SpringCloudTut2ServiceApplication, SpringCloudTut4ServiceApplication).
- Access the Eureka dashboard at http://localhost:8081/ to see registered services.
- Test the endpoints provided by each service.
