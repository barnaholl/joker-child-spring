# joker-child-spring

Netlify: https://jokerchildapplication.netlify.app/
Heroku: https://joker-child-spring.herokuapp.com/swagger-ui.html
Frontend library: https://github.com/balintligeti/jokerchildfrontendapp

## Project introduction
We got this project via Codecool and the product owner is the JokerChild team who won the EdisonKids idea competition. 
They created an educational card game designed to introduce children to various professions.
The web application supports this game by removing the need for human resources(teachers or parents).
We create a platform where students can answer the questions of the hard copy cards, get feedback on their answers and give them the opportunity to ask for help when necessary.
We've also created an admin page for maintainability, where the admins can add new professions and new cards to the database as the game develops.
It is uncertain how long can we work on this project, so we are always strive for the minimum viable product.

## Team
This project is a simulation of Codecool, where teams of students from different backgrounds and skill levels were created from different Codecool courses.
Our team consists of 8 members: 2 project managers, 1 backend developer, 2 fullstack developers and 3 manual testers.
We use SCRUM to keep the team organized and well informed.

## Technologies
### Frontend
For the frontend we are using React.js with Html, Css and Javascript. 
We use axios to api calls and react-bootstrap to create reusable, maintainable components.
We deployed the frontend app to Netlify for testing and presentation purposes.

### Backend
For the backend we chose Java, Spring Boot and Hibernate as our ORM.
We also implemented Spring Security with Jwt Tokens which are stored in httponly cookie.
For API documentation we used Swagger2 and Swagger-UI.
We deployed the backend to Heroku at first day of development, so the frontend developers do not have to run the backend during development and now we also need it to support our application on Netlify.

### Database
We use H2 database for development because it is easy to test.
We use PSQL for production, the main reason being that Heroku has a free, easy-to-use plugin for Postgres.

### Planning
We used Figma to create the wireframe.

### Project Management
We have our backlog in a Trello table, we use this to create spints and for bug tracking as well.



