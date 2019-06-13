# Architecture

## Diagram

![architecture](ArchitechtureFlowchart.png)

## Presentation Layer
[MainActivity]()
- This file is responsible for the view of the application starting screen.

[AddTaskActivity]()
- This file creates the adding a new task view.

[ShowCompletedTaskActivity]()
- This file creates the showing completed tasks view.

[ShowTaskActivity]()
- This file creates the list of tasks view

[UpdateTaskActivty]()
- This files creates the updating or modifying an existing task view.

## Application Layer
[Services]()
- Sets up the databases AccountPersistence and TaskPersistence.

## Business/Logic Layer
[AccessAccount]()
- Business layer logic to access an account in the AccountPersistence. Used to Manipulate an Account object.

[AccessTask]()
- Business layer logic to access an account in the TaskPersistence. Used to manipulate Task objects.

[CalculatePoints]()
- Business layer logic intended to calculate points when user completes a task.

[DateValidation]()
- Business layer logic to check for valid date when inserting new task. AddTaskActivity cannot proceed further if it does not pass this test.

[StringConverter]()
- Business layer logic to convert information received from Task object into astring for display purposes.

## Persistence Layer
[AccountPersistence]():
- The interface for the accounts in the database

[TaskPersistence]():
- The interface for the list of tasks in the database

[AccountPersistenceStub]()
- AccountPersistenceStub implements AccountPersistence and acts as current database for the application 

[TaskPersistenceStub]()

- TaskPersistenceStub implements TaskPersistence and acts as current database for the application
## Domain Specific Objects
[Account]():
-  This class represents a single user account

[Task]():
- The object for the task of an account

[Plant]():
- The object for the Plant feature of our application

## Docs

[View other docs](docs\)