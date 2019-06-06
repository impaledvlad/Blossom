package bruteforce.business;
import java.util.Date;
import bruteForce.objects.*;
import bruteforce.objects.Task;
import bruteforce.objects.Account;
import bruteforce.objects.Plant
/**
Class: CalculatePoints
Author: Ahmed Kidwai
Purpose: Business layer logic, intended to calculate points if task if finished.
 */

public class CalculatePoints {

    private Plant currPlant;
    private Task currTask;
    
    // Constructor
    public CalculatePoints(Plant currPlant, Task currTask){

        this.currPlant = currPlant;
        this.currTask = currTask;
    }

    public void updatePoints() {

        int points = new int [25, 50, 75, 100];
        int awarded = 0;
        int currPoints = currPlant.getGrowthLevel()
        
        // Check if completed.
        boolean status = currTask.getCompleted();
        // if completed we can update points
        if(status) {
            
            // priority is between 1-4 use it as an index.
            int priority = currTask.getPriority();

            // Set points to be awarded.
            awarded = points[priority];
            currPlant.setGrowthLevel(curroints+awarded);
        }
    }
}
