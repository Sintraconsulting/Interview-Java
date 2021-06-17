# Interview-Java
Java interview game

## Guideline for candidate
Candidate has to create Restful CRUD endpoints to manage Users

## Game Rules
In order to maintain things simple, the application has to follow OOP approach, 
so no specific framework knowledge is needed, but Spring is preferable.

The application has to be stable.

No skeleton is provided. Developer can provide any solution to proof his/her skills.

## Requirements
User entity structure:

- email
- lastname
- firstname
- fiscal code
- description (optional)
- last access date (optional)
- identity card number
- identity card image hash
- identity card (image)

### NOTE:
There cannot be more users with the same email or identity card number in the DB
All fields optional can be null


## Scenario
Given an identity card image with related hash application have to check it before insert/update


## Expectations
The expectations are:  
Modelling needed entities  
Validating inputs  
Handling errors  
Saving the file everywhere you prefer (Keep in mind the storage provider could change)  
Highlighting complexities you have to cover  
Writing tests!
