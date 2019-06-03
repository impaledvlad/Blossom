import java.util.*;
/** 
Class: Task
Author: John Manning
Purpose: To model a task object. includes getters, setters, deadline, etc.
*/

public class Task{
//fields

    private String name;
    private Date deadline;
    private boolean completed;
    //task value

//constructors
    public Task(){
    this.deadline = new Date();

    }
    public Task(String name){
        this.deadline = new Date();

        this.name = name; this.completed = false;
    }
    public Task(String name, Date deadline){
        this.deadline = new Date();
        this.name = name; this.deadline = deadline; this.completed = false;

    }
    public Task(String name, Date deadline, boolean completed){
        this.deadline = new Date();

        this.name = name; this. deadline = deadline; this. completed = completed;
    }
//methods
    /** 
    getCompleted

    Purpose: 
    Parameters: 
    Returns: 
    */
    public boolean getCompleted(){
            return completed;
    }
    /** 
    setCompleted()

    Purpose: 
    Parameters: 
    Returns: 
    */
    public void setCompleted(boolean taskCompleted){
        this.completed = taskCompleted;
    }

    /** 
    getName

    Purpose: 
    Parameters: 
    Returns: 
    */
    public String getName(){
        return this.name;
    }
    /** 
    setName

    Purpose: 
    Parameters: 
    Returns: 
    */
    public void setName(String newName){
        this.name = newName;
    }
    /** 
    getDeadline

    Purpose: 
    Parameters: 
    Returns: 
    */
    public Date getDeadline(){
        return this.deadline;
    }
    /** 
    setDeadline

    Purpose: 
    Parameters: 
    Returns: 
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
        return "-Task Object- \nName: " + this.name + "\nDeadline: " + this.deadline.toString()+ " \nCompleted: "+this.completed;
    }

}