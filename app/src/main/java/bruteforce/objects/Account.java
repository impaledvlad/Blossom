package bruteforce.objects;

import java.util.*;

/** 
Class: Account
Author: John Manning
Purpose: This class represents a single user account. the account has an ArrayList of Tasks and a plant object, 
        as well as a username and password.
*/

public class Account {
//fields
    private ArrayList<Task> userTasks;
    private String username;
    private String password;
    private Plant userPlant;

//constructors
    public Account(){
        this.username = "username"; this.password = "password"; this.userTasks = null;
    }
    public Account(String username, String password){
        this.username = username; this.password = password; this.userTasks = new ArrayList<Task>();
    }
    public Account(String username, String password, ArrayList<Task> userTasks){
        this.username = username; this.password = password; this.userTasks = userTasks;
    }
//methods
   
    /** 
    getUsername

    Purpose: returns the name of the account object.
    Parameters: none
    Returns: String
    */
    
    public String getUsername(){
        return username;
    }
    /** 
    setUsername

    Purpose: to set the username (idk why this is necessary tbh but I made it anyways)
    Parameters: String newName
    Returns: void
    */
    public void setUsername(String newName){
        this.username = newName;
    }
    /** 
    getPlant

    Purpose: returns the users plant object.
    Parameters: none
    Returns: Plant
    */
    public Plant getPlant(){
        return this.userPlant;
    }
    /** 
    getUserTaskList

    Purpose: returns the users TaskList
    Parameters: none
    Returns: ArrayList<Task>
    */
    public ArrayList<Task> getUserTaskList(){
        return this.userTasks;
    }

    /** 
    toString

    Purpose: to represent the Object as a single string (useful for examining on the backend)
    Parameters: none
    Returns: A String
    */
    public String toString(){
        return
        "-Account Object-\nUsername: " + this.username + 
        "\nPassword: " +this.password+ 
        "\nuserTasks: " +this.userTasks.toString();
    }
    
}