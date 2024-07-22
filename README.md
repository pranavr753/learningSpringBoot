#Learnings from Commit 1
Initializing a spring project should be done with the help of springinitializer.io with the web starter dependency.
Mainly the code flow is between Controllers, DTOs(Data Transfer Object), Entities, Repositories and Service

Controllers maintain all endpoints details
DTOs contain the object structure that is expected and given in the request-response cycle
Entities are also classes but these are used to communicate with the database
Repository is the main medium that extends Jparepository and connects us to the database. In my case its a local h2 postgres database that has a file path set up.

Using an instance of this Repository we can make CRUD operations like findById, findAll and save().

We also included the h2(for database config) and lombok(for setters and getters and constructors for entities)

Upon Enabling spring.h2.console.enabled=true in application.properties we also got a nice UX to view our database in the browser at localhost:8080/h2-console

spring.jpa.hibernate.ddl-auto=update, I had set this to update once the table was created(for which i had done spring.jpa.hibernate.ddl-auto=create) so that the data persists.

-----X-----X------X

Learnings from Commit 2:
- Addtional POM.xml files added were 
1. spring-boot-starter-validation - This helps in validating our payload sent b4 the controller method gets called. We have to include the @Valid annotation just after the @requestBody annotation and add these in our EmployeeDTO class since that is the object type we are expecting the payload to be.
2. modelMapper - helps map from service to dto and vice versa. The controller communicates with service which communicates with database/repository.
   ![image](https://github.com/user-attachments/assets/9f9458ae-dce7-469c-9362-1265a2b6706c)


- ReflectionUtils was another library that helped us map our patch requests from Map<String, Object> to the respective employeeEntity fields
- Response entity: helps us send the right status codes and messages
- Streams and lambda expressions

