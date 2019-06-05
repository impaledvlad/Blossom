package bruteforce.objects;
import android.support.annotation.NonNull;
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
    private int points;

//constructors
    public Account(){
        this.username = "username";
        this.password = "password";
        this.userTasks = null;
        this.points = 0;
    }
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.userTasks = new ArrayList<>();
        this.points = 0;
    }
    public Account(String username, String password, ArrayList<Task> userTasks, int points){
        this.username = username;
        this.password = password;
        this.userTasks = userTasks;
        this.points = points;
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
     getPassword

     Purpose: returns the password of the account object.
     Parameters: none
     Returns: String
     */

    public String getPassword(){
        return password;
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
     getPoints

     Purpose: returns the users Current Points
     Parameters: none
     Returns: int
     */
    public int getPoints() {
        return this.points;
    }
    /**
     setPoints

     Purpose: set the current points when gain or redeem points
     Parameters: none
     Returns: int
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /** 
    toString

    Purpose: to represent the Object as a single string (useful for examining on the backend)
    Parameters: none
    Returns: A String
    */
    @NonNull
    public String toString(){
        return
        "-Account Object-\nUsername: " + this.username + 
        "\nPassword: " +this.password+ 
        "\nuserTasks: " +this.userTasks.toString()+
                "\nPoints: " +this.points;
    }
    
}