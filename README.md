# Book's library

### Postman commands for docker

###### Inject Data:
- Post: localhost:8081/inject

###### Author:
- Post: localhost:8081/authors    
  body: {"name":"Kidruk","birthDate":"01.04.1984","phone":12345678910,"email":"kidruk@gmail.com"}
- Get: localhost:8081/authors/most/successful
- Put: localhost:8081/authors/{id}   
  body {"name":"Kidruk","birthDate":"01.04.1984","phone":12545678910,"email":"kidruk@gmail.com"}
- Delete: localhost:8081/authors/{id}

###### Books
- Post: localhost:8081/books  
  body: {"name":"Bot: The Guayaquil paradox","authorId":2,"publishedAmount":1000,"soldAmount":999}
- Get: localhost:8081/books/most/popular?name=Kidruk
- Get: localhost:8081/books/most/publisher?name=Kidruk
- Get: localhost:8081/books/most/popular/all?partName=Kid
- Get: localhost:8081/books/most/publisher/all?partName=Kid
- Get: localhost:8081/books/most/successful?partName=Kid
- Put: localhost:8081/books/{id}    
  body: {"name":"Bot: The Guayaquil paradox","authorId":2,"publishedAmount":1000,"soldAmount":1000}
- Delete: localhost:8081/books/{id}

## Implementation details and technologies

### Project based on 3-layer architecture:
>- Presentation layer (controllers)
>- Application layer (services)
>- Data access layer (DAO)

### Technologies
>- Spring Boot
>- Spring Boot WEB
>- Spring Boot DATA
>- Hibernate
>- Hibernate validator
>- PostgreSQL
>- JSON
>- Lombok
>- Maven

### Diagram DB
![drawing](http://dl4.joxi.net/drive/2022/01/30/0052/3292/3415260/60/10c8f227cc.jpg)

## Setup
>1. Configure Apache Tomcat(V - 9.0.55)
>2. Install PostgreSQL(V - 14.0)
>3. In the src/main/resources/application.properties file change properties to the ones you specified when installing PostgreSQL
>4. add TomCat configuration to run project and start

## Setup by docker
Execute commands in the terminal :
- mvn clean package
- docker-compose up
