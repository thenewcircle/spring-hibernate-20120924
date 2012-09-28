spring-hibernate-20120924
=========================

Course Outline
--------------

Day 1

 - class design:
   Contact, Address
   ContactRepository (init, findAll, find, create, update, delete), AddressRepository (...)
   Setup (servlet context listener)

 - servlets / jsps:
   view all contact names, add a contact
   contact: edit name, address, delete contact

 - JDBC / JNDI / DataSource
   initialize tables in repositories, use raw sql

Day 2

 - finish servlets

 - intro hibernate/jpa
   META-INF/persistence.xml, persistence-unit-ref in web.xml
   javax.persistence.{ Persistence, EntityManager }
   @Entity, @Column, @OneToOne
   Rewrite ContactRepository and AddressRepository (findAll, find, create, update, delete) and refactor

Day 3

 - intro spring
   container-managed objects, dependency injection
   Spring MVC: controllers, @RequestMapping
   Spring JPA: JpaRepository, bytecode generation

 - refactor controller methods
   model, view, injecting request parameters, redirects

 - new class design:
   Contact, Person, Company, Office, Address
   how to represent polymorphism in jpa?
   @OneToMany, @ManyToOne, @ManyToMany

 - controllers:
   person: edit name, address, delete person
   company: edit name, view all offices, add an office, delete company

Day 4

 - office front-end
   introduce UrlEntity helper

 - horrible bugs!
   why doesn't delete work? ... orphan removal
   lazy loaded associations, open session in view filter

 - discussion: Spring high level
 - discussion: Transactions and AOP
 - discussion: Entity versioning, optimistic locking

 - data constraints
   nullable, length
   Validation (ex: @NotBlank, all employees of a manager must work for the same company)

Day 5

 - REST services
   more Spring MVC annotations
   Jackson


JDBC Pain Points / ORM Requirements
-----------------------------------

Code maintenance/evolution issues:
  - entity and sql can get out of sync as code evolves
    => objects must determine DB schema!
  - one must know sql
    => should be able to just get objects from somewhere / persist objects
  - no explicit relationship between entities (one-to-one???)
    => system must know relationships and constraints

Flexibility/reuse issues:
  - code is tied to a specific SQL implementation (dialect)

General ugliness/boilerplate:
  - very repetitive code, lots of try-finally
    => forget JDBC
  - checked SQLExceptions everywhere
    => forget JDBC
  - marshalling and unmarshalling is very clumsy

Performance/correctness issues:
  - no joins
  - no transactions
  - no good way to "create table if not exists"

Reference Material
------------------

* http://static.springsource.org/spring/docs/current/spring-framework-reference/html/mvc.html
* http://docs.jboss.org/hibernate/annotations/3.5/reference/en/html_single/

Videos
------

* Day 1
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/1.1.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/1.2.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/1.3.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/1.4.mov
* Day 2
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/2.1.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/2.2.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/2.3.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/2.4.mov
* Day 3
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/3.1.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/3.2.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/3.3.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/3.4.mov
* Day 4
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/4.1.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/4.2.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/4.3.mov
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/4.4.mov
* Day 5
  * https://mrkn.s3.amazonaws.com/recordings/spring-hibernate-20120924/5.1.mov
