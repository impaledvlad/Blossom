package bruteforce.business;
import bruteforce.objects.Account;
import bruteforce.objects.Task;


/**
 Class: CalculatePoints
 Author: Ahmed Kidwai
 Purpose: Business layer logic, intended to calculate points if task if finished.
 */

public class CalculatePoints {

    private AccessAccount currAccountPersistence;
    private AccessTask currTaskPersistence;
    private String userName;

    // Constructor.
    public CalculatePoints(AccessAccount currAccountPersistence, AccessTask currTaskPersistence, String userName) {

        this.currAccountPersistence = currAccountPersistence;
        this.currTaskPersistence = currTaskPersistence;
        this.userName = userName;

    }
    public CalculatePoints(AccessAccount currAccountPersistence, AccessTask currTaskPersistence) {

        this.currAccountPersistence = currAccountPersistence;
        this.currTaskPersistence = currTaskPersistence;
    }

    /**
     Class: awardPoints
     Author: Ahmed Kidwai
     Purpose: This method will award points to a user when a task has been completed.
     */

    public int awardPoints() {

        int [] points = {25, 50, 75, 100};
        int currPoints;


        Account currAccount = currAccountPersistence.getCurrentAccount();
         currPoints = currAccount.getPoints();

        // Get the priority.
        int priority = currTaskPersistence.completeTask();


        // If priority isn't default lets award points
        if(priority != -1) {

            int awarded = points[priority];

            currPoints += awarded;
            currAccountPersistence.updatePoints(currPoints);
        }

        return currPoints;
    }
}
