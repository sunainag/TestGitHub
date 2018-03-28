# TestGitHub

GitHub tutorial
Testing push and pull from Git

1.@SpringBootApplication which is a combination of the following more specific spring annotations -

@Configuration : Any class annotated with @Configuration annotation is bootstrapped by Spring and is also considered as a source of other bean definitions.
@EnableAutoConfiguration : This annotation tells Spring to automatically configure your application based on the dependencies that you have added in the pom.xml file.
For example, If spring-data-jpa is in the classpath, then it automatically tries to configure a DataSource by reading the database properties from application.properties file.
@ComponentScan : It tells Spring to scan and bootstrap other components defined in the current package (com.example.easynotes) and all the sub-packages.

The main() method calls Spring Boot’s SpringApplication.run() method to launch the application.

2. resources/
This directory, as the name suggests, is dedicated to all the static resources, templates and property files.
resources/static - contains static resources such as css, js and images.
resources/templates - contains server-side templates which are rendered by Spring.
resources/application.properties - This file is very important. It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.
You can refer this page for common application properties used in Spring Boot.
3. EasyNotesApplicationTests - Define unit and integration tests here.
4. pom.xml - contains all the project dependencies

The property spring.jpa.hibernate.ddl-auto is used for database initialization. I’ve used the value “update” for this property.
It does two things -
When you define a domain model, a table will automatically be created in the database and the fields of the domain model will be mapped to the corresponding columns in the table.
Any change to the domain model will also trigger an update to the table. For example, If you change the name or type of a field, or add another field to the model, then all these changes will be reflected in the mapped table as well.
But, For production, You should keep the value of this property to “validate”, and use a database migration tool like Flyway for managing changes in the database schema.

@Repository annotation. This tells Spring to bootstrap the repository during component scan.

@NotBlank annotation is used to validate that the annotated field is not null or empty.

@Temporal annotation is used with java.util.Date and java.util.Calendar classes. It converts the date and time values from Java Object to compatible database type and vice versa.

@JsonIgnoreProperties annotation is a Jackson annotation. Spring Boot uses Jackson for Serializing and Deserializing Java objects to and from JSON.
This annotation is used because we don’t want the clients of the rest api to supply the createdAt and updatedAt values. If they supply these values then we’ll simply ignore them. However, we’ll include these values in the JSON response.

CreatedAt and updatedAt fields are annotated with @CreatedDate and @LastModifiedDate annotations respectively.
what we want is that these fields should automatically get populated whenever we create or update an entity.To achieve this, we need to do two things -
1. Add Spring Data JPA’s AuditingEntityListener to the domain model: @EntityListeners(AuditingEntityListener.class)
2. Enable JPA Auditing in the main application: @EnableJpaAuditing

@RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
@ResponseBody annotation is used to indicate that the return value of a method should be used as the response body of the request.
@PathVariable annotation, as the name suggests, is used to bind a path variable with a method parameter
@DeleteMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE)
 
 
Hibernate:

@GeneratedValue JPA Annotation
Quite often in these tutorials, we have used the @GeneratedValue annotation to have thedatabase generate a unique primary key for us. We have used the default Generation Type in each of our examples, but there are actually four different strategies for having the primary key generated by the database. Those four options are:
AUTO IDENTITY TABLE SEQUENCE javax.persistence.GenerationType.AUTO
The AUTO generation strategy is the default, and this setting simply chooses the primary key generation strategy that is the default for the database in question, which quite typically is IDENTITY, although it might be TABLE or SEQUENCE depending upon how the database is configured. The AUTO strategy is typically recommended, as it makes your code and your applications most portable.
javax.persistence.GenerationType.IDENTITY
The IDENTITY option simply allows the database to generate a unique primary key for your application. No sequence or table is used to maintain the primary key information, but instead, the database will just pick an appropriate, unique number for Hibernate to assign to the primary key of the entity. With MySQL, the first lowest numbered primary key available in the table in question is chosen, although this behavior may differ from database to database.
javax.persistence.GenerationType.Sequence
Some database vendors support the use of a database sequence object for maintaining primary keys. To use a sequence, you set the GenerationType strategy to SEQUENCE, specify the name of the generator annotation, and then provide the @SequenceGenerator annotation that has attributes for defining both the name of the sequence annotation, and the name of the actual sequence object in the database.

@ElementCollection
use an element collection to persist a Collection of value types. You just need to annotate the attribute with @ElementCollection and the persistence provider will persist the elements of the Collection in an additional database table.
The element collection might seem easier to use than an entity with a one-to-many association. But it has one major drawback: The elements of the collection have no id and Hibernate can’t address them individually.
When you execute this code, Hibernate performs 2 SELECT statements to read the Author entity and the associated phoneNumbers. Then I add the second phoneNumber to the element collection. And Hibernate updates the Author entity, drops all associated phoneNumbers and inserts a new record for each phoneNumber.
@CollectionTable 
will join the two tables for the given primary and foreign key. 


We use @ElementCollection annotation to declare an element-collection mapping. All the records of the collection are stored in a separate table. The configuration for this table is specified using the @CollectionTable annotation.
The @CollectionTable annotation is used to specify the name of the table that stores all the records of the collection, and the JoinColumn that refers to the primary table.
Moreover, When you’re using an Embeddable type with Element Collection, you can use the @AttributeOverrides and @AttributeOverride annotations to override/customize the fields of the embeddable type.

Natural primary key: primary key due to functional requirement, like email, login id
Surrogate key: just to make the row unique, like serial number

use @AttributeOverride: when a user has say two address members: office address and home address.
Then, how to differentiate the @Embedded Address objects for both. Then use @AttributeOverride
Refer https://www.youtube.com/watch?v=X8t6oYp0Uk8&list=PL4AFF701184976B25&index=11

@EmbeddedId if we want to use an embeddable object as primary key: no need to use @id and @Embedded.


//TODO:
1.Builder pattern in User pojo
2.Difference in get and load

@CollectionId : hibernate annotation
used to provide indexing to @ElementCollection table : use a collection which supports indexing- like Arraylist
@GenericGenerator(name="hilo-gen",strategy="hilo")
Reference: https://www.youtube.com/watch?v=kk207HAym_I&list=PL4AFF701184976B25&index=13

Hibernate Entity / Persistence LifeCycle States:
Given an instance of an object that is mapped to Hibernate, it can be in any one of four different states: transient, persistent, detached, or removed
1. Transient objects exist in heap memory. Hibernate does not manage transient objects or persist changes to transient objects.
To persist the changes to a transient object, you would have to ask the session to save the transient object to the database, at which point Hibernate assigns the object an identifier and marks the object as being in persistent state.
2. Persistent objects exist in the database, and Hibernate manages the persistence for persistent objects
3. Detached objects have a representation in the database, but changes to the object will not be reflected in the database, and vice-versa
4. Removed objects are objects that are being managed by Hibernate (persistent objects, in other words) that have been passed to the session’s remove() method. When the application marks the changes held in the session as to be committed, the entries in the database that correspond to removed objects are deleted.



One-to-one mapping:	Either end can be made the owner, but one (and only one) of them should be; if you don’t specify this, you will end up with a circular dependency.
One-to-many:	The many end must be made the owner of the association.
Many-to-one:	This is the same as the one-to-many relationship viewed from the opposite perspective, so the same rule applies: the many end must be made the owner of the association.
Many-to-many:	Either end of the association can be made the owner.



JPA Cascade Types
The cascade types supported by the Java Persistence Architecture are as below:

CascadeType.PERSIST : means that save() or persist() operations cascade to related entities.
CascadeType.MERGE : means that related entities are merged when the owning entity is merged.
CascadeType.REFRESH : does the same thing for the refresh() operation.
CascadeType.REMOVE : removes all related entities association with this setting when the owning entity is deleted.
CascadeType.DETACH : detaches all related entities if a “manual detach” occurs.
CascadeType.ALL : is shorthand for all of the above cascade operations.