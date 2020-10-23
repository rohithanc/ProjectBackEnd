##### Table of Contents  

### Brief
To create a CRUD (Create, Read, Update, Delete) application
The following topics learnt over the last few weeks will be utilised:
  - Java
  - SQL
  - HTML / CSS
  - JavaScript
  - Google Cloud

The Back-end will be using SpringBoot and the code is written in Java.
SpringBoot is a Java-based framework used to run applications or micro-services.
The application being created was organised in a three-tier architecture structure.

- ***Presentation Layer***- the front-end, designed with *HTML, CSS and JavaScript*
    - Makes requests to business layer with JavaScript
  - ***Business Layer***- the back-end, deployed on SpringBoot, written with Java code
    - Sends Queries to Data Layer Database
    - Sends Response to the front-end
  - ***Data Layer***- the database which contains the data to be returned to the business layer when queried. H2 and MySQL is utilised in this project

### Requirements
- Kanban Board: Jira
- Database: GCP Managed SQL Server
- Programming language: Java (unless stated otherwise)
- Front-end: HTML, CSS and JavaScript
- Unit Tests: JUnit and Mockito
- Integration Tests: MockMVC
- Version Control: Git  

### My Approach
I have decided to create a simple Player Creation app. The user of the site will be able to
- create a player with details: ***(Create)***
  - player name
  - player age
  - player position
  - player goals
- view the created player in a database underneath ***(Read)***
- delete their player ***(Delete)***
- update the player's details ***(Update)***

### Planning
The Minimal Viable Product was a form that would create players by inserting information about their name, age, position and previous goals scored, show the information and be able to delete and update the information.
A Jira Kanban board was used to keep track of the requirements and of the progress towards a Minimal Viable Product. 
The Kanban board is made of User Stories consisting of tasks to be completed. The Kanban board had four sections- **backlog** for tasks that were scheduled but didn't have any progress made yet, **Selected For Development** for tasks that were to be worked upon, **In Progress** for tasks that were in progress and **Done** for tasks that have been completed.

### Risk Assessment
The risk assessment can be found [here](https://docs.google.com/spreadsheets/d/e/2PACX-1vRuO2LKyoG2tcCBec8I9XLGibm4NtrnP5WUB94c6DryT6Z-KPkODIdA_qvlDzHpJo3lJpYZng6amJ5S/pubhtml)

### Testing
JUnit testing and Integration tests were used in order to test the application.
Mockito was attempted as well.

### Front End Design
The Front-End was designed on Microsoft Visual Studio, using HTML, CSS and JavaScript  coding languages.

### Issues Encountered during Project
- For a while, the goals were not be able to shown in the front end.
- Updating the player took a lot of time to configure. The front end would not know which player was being updated.
  - This problem was solved by incorporating a function to select specific players by ID and by adding an input for the player ID.
- Mockito testing was not providing the desired coverage
  
### Improvements and Ideas for Future CRUD Projects
- Add more details and attributes to keep track of.
  - other details I would have wanted to keep track of were Nationalities, Favoured foot, Previous clubs, physical attributes such as weight and height and more performance based statistics such as assists, appearances etc.
- Be able to list players by each detail.
  - (Initially I planned to have the site have a function to list players by position but I was unable to do that within the time frame.)
