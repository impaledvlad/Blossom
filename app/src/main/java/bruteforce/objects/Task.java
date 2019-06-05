package bruteforce;

import java.util.*;
/** 
Class: Task
Author: John Manning
Purpose: To model a task object. includes getters, setters, deadline, etc.
*/

public class Task{
    //TO DO - update toString to provide taskID.
//fields
    private static int taskIDIterator;
    private String name;
    private Date deadline;
    private boolean completed;
    private int taskID;
    //task value

//constructors
    public Task(){
    this.deadline = new Date();
    this.name = "";
    this.completed = false;
    this.taskID = taskIDIterator++;
    }
    public Task(String name){
        this.name = name; this.completed = false;
        this.taskID = taskIDIterator++;

    }
    public Task(String name, Date deadline){
    this.name = name; this.deadline = deadline; this.completed = false;
    this.taskID = taskIDIterator++;

    }
    public Task(String name, Date deadline, boolean completed){
        this.name = name; this. deadline = deadline; this. completed = completed;
        this.taskID = taskIDIterator++;
    }
//methods
    /** 
    getCompleted

    Purpose: Returns the boolean completed value
    Parameters: none
    Returns: boolean
    */
    public boolean getCompleted(){
            return completed;
    }
    /** 
    setCompleted()

    Purpose: sets the completed value
    Parameters: boolean taskCompleted
    Returns: void
    */
    public void setCompleted(boolean taskCompleted){
        this.completed = taskCompleted;
    }
      /** 
    getTaskID()

    Purpose: gets the unique taskID
    Parameters: none
    Returns: an int
    */
    public void getTaskID(){
        return taskID;
    }
    /** 
    getName

    Purpose: gets the name of the task
    Parameters: none
    Returns: String
    */
    public String getName(){
        return this.name;
    }
    /** 
    setName

    Purpose: Sets the name of the task
    Parameters: String newName
    Returns: void
    */
    public void setName(String newName){
        this.name = newName;
    }
    /** 
    getDeadline

    Purpose: gets the deadline for this task
    Parameters: void
    Returns: Date object
    */
    public Date getDeadline(){
        return this.deadline;
    }
    /** 
    setDeadline

    Purpose: sets the deadline for the object
    Parameters: Date newDeadline
    Returns: void
    */
    public void setDeadline(Date newDeadline){
        this.deadline = newDeadline;
    }
    /** 
    toString

    Purpose: To represent the Task Object as a String. (for debugging purposes);
    Parameters: none
    Returns: A string representation of the task data.
    */
    
    public String toString(){
        return "-Task Object- \nName: " + this.name + "\nDeadline: " + this.deadline.toString()+ 
        " \nCompleted: "+this.completed +"\ntaskID: " + this.taskID;
    }

}