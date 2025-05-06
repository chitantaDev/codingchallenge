# Coding Challenge Database & Backend Setup

### 1. Create a New Database

1.1 Download and install PostgreSQL https://www.postgresql.org/download/ 
1.1.1 *(Optional)* Download and Install pgAdmin (GUI) https://www.pgadmin.org/download/

1.1 Connect to PostgreSQL using the following terminal command:

    psql -U your_username -d postgres

1.2 Execute database creation command

    CREATE DATABASE your_database_name;

1.3 Connect to created database

    \c your_database_name;

### 2. Run the SQL Script

2.1 Before running the script -> Open tables.sql
change all "OWNER" fields to "your_username"

2.2 Make sure you are connected to the newly created database and execute "tables.sql" with this command: 

    \i /absolute/path/to/your/tables.sql

### 3. Adjust Backend Configurations

3.1 Go into the backend /src/main/resources/application.properties and replace the database url

from: 

spring.datasource.url=jdbc:postgresql://localhost:5432/coding_challenge

to:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name

3.2 Start Spring Boot backend (READ THE SECTION BELLOW - IMPORTANT)

## IMPORTANT
 - If asked for a database username and password by your IDE, leave the fields empty. No password has been set up.
 - only works with a psql superuser. If you're not a superuser:
   - create psql user
   - adjust the tables.sql script with the newly created user
   - add the following two lines in your spring application.properties
     - spring.datasource.username="your_database_username" 
     - spring.datasource.password="your_database_password"