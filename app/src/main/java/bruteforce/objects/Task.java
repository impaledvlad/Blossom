package bruteforce.objects;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.os.Parcelable;
import android.support.annotation.NonNull;

/** 
Class: Task
Author: John Manning
Purpose: To model a task object. includes getters, setters, deadline, etc.
*/

public class Task implements Serializable {
    private static int taskIDIterator = 0;
    private String username;
    private String name;
    private Date deadline;
    private boolean completed;
    private int taskID;
    private int priority; //priority(0 for low priority, 1 for medium priority, 2 for high priority, -1 for default);

    public Task() {
    	this.deadline = new Date();
    	this.name = "";
    	this.username = "";
    	this.completed = false;
    	this.taskID = taskIDIterator++;
    	this.priority = -1;
    }
    
    public Task(String name) {
        this.name = name;
        this.username = "";
        this.completed = false;
        this.taskID = taskIDIterator++;
        this.priority = -1;

    }

    public Task(String name, Date deadline) {
        this.name = name;
        this.username = "";
        this.deadline = deadline;
        this.completed = false;
        this.taskID = taskIDIterator++;
        this.priority = -1;
    }
    
    public Task(String name, String username, Date deadline, boolean completed, int priority) {
        this.name = name;
        this.username = username; 
        this.deadline = deadline;
        this.completed = completed;
        this.taskID = taskIDIterator++;
        this.priority = priority;
    }

    /**
    getUsername()

    Purpose: get the username of a task
    Parameters: none
    Returns: Returns the String username
    */
    public String getUsername() {
        return username;
    }

    /** 
    getCompleted

    Purpose: Returns the boolean completed value
    Parameters: none
    Returns: boolean
    */
    public boolean getCompleted() {
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
    public int getTaskID(){
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
    public Date getDeadline() {
        return deadline;
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
     getPriority

     Purpose: gets the priority for this task
     Parameters: void
     Returns: int
     */
    public int getPriority(){
        return priority;
    }

    /**
     setPriority

     Purpose: sets the priority for the object
     Parameters: int newPriority
     Returns: void
     */
    public void setPriority(int newPriority){
        this.priority = newPriority;
    }

    /** 
    toString

    Purpose: To represent the Task Object as a String. (for debugging purposes);
    Parameters: none
    Returns: A string representation of the task data.
    */
    @NonNull
    public String toString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.CANADA);
        String strDate = dateFormat.format(deadline);

        return "-Task Object- \nName: " + this.name + "\nDeadline: " + strDate + " \nCompleted: "+this.completed +"\ntaskID: " + this.taskID;
    }
}