# Branching Standards

## Project Development Branch
Our main development branch for this project will be `project-3350` branch. Any feature branch you create during development, you should create from this project branch. Always make sure the application is working as expected on this project branch at first. We will only merge this project branch with `master` branch when we are sure the application is working on the `project-3350` branch.

## Feature Branch
Make sure to create any feature branch from the most up-to-date `project-3350` branch. Feature branch should be named with the following standard - <br><br> `feature-issue#-feature-name`. <br>

For example, if you want to create a feature branch for our Feature 1 - Account Management, you can create it by the following command. <br><br>
`git checkout -b feature-1-account-management`


## User Branch
Always create your user branch from the feature branch you are working on so that multiple users can work on the same feature at the same time. User branch should be named with the following standard - <br>

`user-issue#-task-name`

For example, if you want to work on user story issue# 8 to create an account, you can create it by the following command. <br><br>
`git checkout -b user-8-create-account`

## Commit Message 
Make sure to add meaningful and descriptive commit message. If you are working on different user stories at the same time, make sure you add the GitLab Issue# on your commit message so that we can differentiate the user stories. You can find the issue# on the task description of GitLab.

For example, if you are working on the user story issue# 8 to create an account and added UI for it, you should have a commit message like the following.  <br><br>

`User Issue #8 - Added UI for creating an account`

## Code Review 
When you are done with your development and testing of your user branch, push it to our remote repository on GitLab and create a `merge request` so that one of the other member can start a code review. In your merge request, add the feature/user issue# and name in the title, description of what changes you made, set assignee for doing review, source branch is the user branch you pushed, destination branch is the feature branch of the project. If it's a simple user story, it should be code reviewed by one of the members of the project except yourself. If it's a complex user story, it should be code reviewed by atleast two other members of the project except yourself. 

## Branch Merging
User branch can be merged with the feature branch once you are done both with development and code review. Once all the user stories of a feature is done with development and code-review, they can be merged with the respective feature branch. Feature branch should then be merged with development branch `project-3350`. Make sure `project-3350` branch is working as expected with the newly added feature. We will usually merge the project branch `project-3350` with the `master` branch before each iteration deadline date. These branching techniques will allow us to have clean and working code on the master branch all the time and will not create any disturbance to other members during development.