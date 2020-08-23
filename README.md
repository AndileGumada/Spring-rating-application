Spring boot and React full stack Ratings application
===============================
# STILL A WORK IN PROGRESS APPLICATION...


	```
	Home page

	```
![]()

    ``` 
     I will be building a Reddit clone with Spring Boot, React, and Electron.
      I will be using varies Spring Technologies like Spring Data JPA, Spring Security
      with JWT, and PostgreSQL for the database with Redis for Caching. The 
      frontend portion will be using React with Typescript, Redux for state management, and Material-UI.
    ```
	
## Technologies and Tools used

	```
	* Spring Tool Suite 4.2.2.RELEASE
	* Hibernate JPA 
	* Maven built-tool 3
	* PostgreSQL 9 pgAdmin 4
	* Lombok(Java Library) minimizes boilerplate code
	* Fly way(Version control for Databases)
	* HTML5 , CSS3
	* TypeScript
	* Angular 9 CLI 
	* jQuery 1.10.2
	* Boostrap 3
	* Visual Studio Code
	* Font-awesome 
	```
## Create a Mailtrap Account
    ```
    To send account verification and notification emails. 
    The reason this is needed is to have access to a fake SMTP Server through MailTrap.
     You can access the connections details by logging in, and selecting the cog icon on the demo inbox.
    ```
## Clone the application

	```
	git clone https://github.com/andile/book-api.git
	cd book-api
	```
### Create the jar file for Spring application

	```
	./mvnw package
	java -jar ./target/book-api-0.0.1-SNAPSHOT.jar
	
	```
Access ```http://localhost:4000```

## Create PostgreSQL database

	```bash
	create database online-book-db;
	```

## Change PostgreSQL username and password as per your PostgreSQL installation

	+ open `src/main/resources/application.properties` file.

	+ change `spring.datasource.username` and `spring.datasource.password` properties as per your PostgreSQL installation
## To import this project into Eclipse IDE

	 ```$ mvn eclipse:eclipse```
	 Import into Eclipse via **existing projects into workspace** option.
	 Done.
	```

