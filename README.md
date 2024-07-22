#Learnings from Commit 1
Initializing a spring project should be done with the help of springinitializer.io with the web starter dependancy.
Mainly the code flow is between Controllers, DTOs(Data Transfer Object), Entities, Repositories and Service

Controllers maintain all endpoints details
DTOs contain the object structure that is expected and given in the request-response cycle
Entities are also classes but these are used to communicate with the database
Repository is the main medium that extends Jparepository and connects us to the datacase. In my case its a local h2 postgres database that has a file path set up.

Using an instance of this Repository we can make CRUD operations like findById, findAll and save().

We also included the h2(for database config) and lombok(for setters and getters and constructors for entities)

Upon Enabling spring.h2.console.enabled=true in application.properties we also got a nice UX to view our database in the browser at localhost:8080/h2-console

spring.jpa.hibernate.ddl-auto=update, I had set this to update once the table was created(for which i had done spring.jpa.hibernate.ddl-auto=create) so that the data persists.
