# Drone

Languages & Tools
Spring Boot 3.1.1
Java 17 
H2 database
Spring Boot JPA (Java Persistence API)
HATEOAS (REST APIs with Hypermedia)
Mysql 8.0
Docker + Docker Compose


# Db configurations
h2 database is the default database
change db configuration ( uncomment mysql connector dependency reload the maven dependecy in pom.sml file)


# Installation (on Ubuntu)
Install Docker and Docker Compose (Refer https://docs.docker.com/engine/install/ubuntu/ and https://docs.docker.com/compose/install/)  when using mysql database in docker.
Clone this repo (git clone ).
Move into the drone folder root folder (cd ).

Run (docker-compose up -d for run mysql in docker)



Change the application.yml configs
Run build  (mvn clean package ) 
Run java -jar <path/to/application.jar>
Run  mvn spring-boot:run

run the data.sql  in src/main/resources/data.sql  to load the the data

their is no user ui 
