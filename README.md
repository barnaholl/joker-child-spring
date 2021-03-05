# joker-child-spring

The application preview:
Netlify: https://jokerchildapplication.netlify.app/
Heroku: https://joker-child-spring.herokuapp.com/swagger-ui.html
Frontend library: https://github.com/balintligeti/jokerchildfrontendapp

## Project introduction
We got this project via Codecool and the product owner is the JokerChild team who won the EdisonKids idea competition. 
They created an educational card game that aims to introduce children to various professions.
The web application is designed to support this game by remove the necessity of human resources(teachers or parents). 
We are creating a platform where studens can answer the questions of the hardcopy cards, 
get feedback on their answers and give them the opportunity to ask for help when neccessary.
We also created an admin page for maintainability, where the admins can add new professions and new cards to the database as the game develops.
It is uncertain how long can we work on this project so we are always aiming for the minimum viable product.

## Team
This project is a simulation by Codecool where they created teams by students with various backgrounds and skill levels from different Codecool courses.
Our team consists of 8 members: 2 Project managers, 1 backend developer, 2 fullstack developers and 3 manual testers.
We are using SCRUM to keep the team organized and well informed.

## Technologies
### Frontend
For the frontend we are using React.js with Html, Css and Javascript. 
We are using axios to api calls and react-bootstrap to create reuseable, maintainable components.
We deployed the frontend app to Netlify for testing and presentation puroses.

### Backend
For the backend we chose Java, Spring Boot and Hibernate as our ORM.
We also implemented Spring Security with JwtTokens that we are storing in httponly cookie.
For API documentation we are using Swagger2 and Swagger-UI.
We deployed the backend to Heroku at first day of development, so the frontend developers do not have to run the backend while developing 
and now we also need it to support our application on Netlify.

### Database
We are using an H2 database for development because it is really easy to test with.
For production we use PSQL, the main reason we chose this is that Heroku has a free easy to use plugin for Postgres.

### Planning
We used Figma to create the wireframe

### Project Management
We have our backlog in a Trello table, we use this to create spints and for bug tracking as well.



