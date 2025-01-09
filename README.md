# Employee_Department_microservices

Create 2 microservices and write the logics
Use RestTemplate for web calls, create bean

Eureka

1)eureka-service

1)download project with one dependency(eureka-server)
2)Add @EnableEurekaServer annotation in main applicatoion file
3) Add server port as 8761 and two line configuration for eureka-server

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

2) Other services

1)Explore dependency for Eureka-discovery-client
    1) Property spring cloud version
	2) Eureka dependency
	3) Dependency management
2) Add eureka configuration in application.properties

#eureka
eureka.client.service-url.default-zone=http://localhost:8761/eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.instance.hostname=localhost

3) Chnge the localhost with service names
4) To make it connect, use @LoadBalanced to restTemplate bean

Api Gateway
1)download project with 2 dependecny (eureka-client, reactive gateway)
2)gateway configuration in application.properties

#eureka
eureka.client.service-url.default-zone=http://localhost:8761/eureka
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
eureka.instance.hostname=localhost

spring.cloud.gateway.routes[0].id=employee-service
spring.cloud.gateway.routes[0].uri=lb://employee-service
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/employee/**

spring.cloud.gateway.routes[1].id=department-service
spring.cloud.gateway.routes[1].uri=lb://department-service
spring.cloud.gateway.routes[1].predicates[0]=Path=/api/department/**

	
COnfig server
1) Create project with 2 dependencies (config server, eureka-client)
2) Add @EnableConfigServer and config in application.properties

3) COmment all repeated config in all application.properties
4)Go to github , create new repo, add repeated app.prop in a file and use that link

Git : https://github.com/PRIYADHARSHINI1911/Employee_Department_microservices.git

==========================================================================================================

Testing

![image](https://github.com/user-attachments/assets/db5b742e-8287-48ef-8d21-560458269cd9)
![image](https://github.com/user-attachments/assets/c37db464-ae63-4efc-8adf-15fc874be754)



