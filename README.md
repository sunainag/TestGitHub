# TestGitHub

GitHub tutorial
Testing push and pull from Git


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