package bruteforce.business;
import bruteforce.application.Services;
import bruteforce.objects.*;
/** 
Class: AccessPlant
Author: John Maning
Purpose: Business layer logic for a users Plant.
*/

public class AccessPlant {
    private Plant accessedPlant;

    public AccessPlant(Plant currPlant) {
        accessedPlant = currPlant;
    }
    public Plant getCurrentPlant()
    {
        return accessedPlant;
    }

}
