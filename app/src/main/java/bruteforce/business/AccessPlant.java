package bruteforce.business;
import bruteforce.application.Services;
import bruteforce.objects.*;
/** 
Class: AccessPlant
Author: John Manning
Purpose: Business layer logic for a users Plant.
*/

public class AccessPlant {
    private Plant accessedPlant;
    //constructor
    public AccessPlant(Plant currPlant) {
        accessedPlant = currPlant;
    }

    /**
     getCurrentPlant

     Purpose: returns the current plant object.
     Parameters: null
     Returns: Plant
     */
    public Plant getCurrentPlant()
    {
        return accessedPlant;
    }

}
