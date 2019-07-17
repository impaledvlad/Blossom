# Architecture

## Diagram

![architecture](ArchitechtureDiagram.png)

## Presentation Layer
[MainActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/MainActivity.java)
- This file is responsible for the view of the application starting screen.

[AddTaskActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/AddTaskActivity.java)
- This file creates the adding a new task view.

[ShowCompletedTaskActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/ShowCompletedTaskActivity.java)
- This file creates the showing completed tasks view.

[ShowTaskActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/ShowTaskActivity.java)
- This file creates the list of tasks view

[UpdateTaskActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/UpdateTaskActivity.java)
- This files creates the updating or modifying an existing task view.

[AccountInfoActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/AccountInfoActivity.java)
- Implements the logic for our account info feature, which allows the user to update their account information.

[DateErrorDialog](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/DateErrorDialog.java)
- A dialog that informs the user when there is an invalid date during task creation.

[LoginActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/LoginActivity.java)
- Implements logic for the login page.

[Messages](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Presentation/Messages.java)
- Contains details for error messages.

[PlantActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/PlantActivity.java)
- Implements the logic for the digital plant.

[RegisterActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/presentation/RegisterActivity.java)
- Implements the logic for creating a new account.

[TitleErrorDialog](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Presentation/TitleErrorDialog.java)
- Implements a dialog that informs the user they are missing a name for their new task

[SummaryActivity](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Presentation/SummaryActivity.java)
- Implements the Summary Feature that displays a summary of tasks completed, incomplete tasks, and total tasks

## Application Layer
[Main](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/application/Main.java)
-  Main Method. Runs the initial setup of the application

[Services](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/application/Services.java)
- Sets up the databases AccountPersistence and TaskPersistence.

#### [Exceptions](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/application/Exceptions)
---
- [ApplicationExceptions](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/application/Exceptions/ApplicationExceptions.java)
     - General application Exceptions file. Sets up the required Exceptions.

## Business/Logic Layer
[AccessAccount](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/AccessAccount.java)
- Business layer logic to access an account in the AccountPersistence. Used to Manipulate an Account object.

[AccessTask](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/AccessTask.java)
- Business layer logic to access an account in the TaskPersistence. Used to manipulate Task objects.

[CalculatePoints](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/CalculatePoints.java)
- Business layer logic intended to calculate points when user completes a task.

[DateInputValidation](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/DataInputValidation.java)
- Business layer logic to check for valid date when inserting new task. AddTaskActivity cannot proceed further if it does not pass this test.

[AccessPlant](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/AccessPlant.java)
- Provides logic for accessing a plant object.

#### [Exceptions](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/Exceptions/)
---
- [AccessingExceptions](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/Exceptions/AccessingExceptions.java)
    - General Business Layer Exceptions.
- [NotLoginExceptions](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/Exceptions/NotLoginExceptions.java)
    - Exceptions for when there are login errors.
- [NotLoginExceptions](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/business/Exceptions/DateException.java)
    - Exceptions for when there are errors choosing a deadline.

## Persistence Layer
[AccountPersistence](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/AccountPersistence.java):
- The interface for the accounts in the database

[TaskPersistence](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/TaskPersistence.java):
- The interface for the list of tasks in the database

#### [HSQLDB](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/hsqldb)
---
- [AccountPersistenceHSQLDB](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/hsqldb/AccountPersistenceHSQLDB.java)
    - Implements AccountPersistence and connects the app to the Account Database

- [PersistenceException](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/hsqldb/PersistenceException.java)
    - A class that contains the exceptions relating to Database errors.

- [TaskPersistenceHSQLDB](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/hsqldb/TaskPersistenceHSQLDB.java)
    - Implements AccountPersistence and connects the app to the Task Database


#### [Stubs](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/stubs/)
---
- [AccountPersistenceStub](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/stubs/AccountPersistenceStub.java)
    - AccountPersistenceStub implements AccountPersistence and acts as temporary database for the application 

- [TaskPersistenceStub](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/Persistence/stubs/TaskPersistenceStub.java)
     - TaskPersistenceStub implements TaskPersistence and acts as temporary database for the application

## Domain Specific Objects
[Account](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/objects/Account.java)
-  This class represents a single user account

[Task](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/app/src/main/java/bruteforce/objects/Task.java)
- The object for the task of an account

[Plant](/https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/masterapp/src/main/java/bruteforce/objects/Plant.java)
- The object for the Plant feature of our application


## Docs 

[View other docs](https://code.cs.umanitoba.ca/comp3350-summer2019/brute-force---11-/blob/master/docs)


