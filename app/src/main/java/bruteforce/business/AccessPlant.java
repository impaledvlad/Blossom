package bruteforce.business;
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
    /**
     addWaterLevel

     Purpose: adds water to the waterlevel of the plant. will update the growth level evey 100
     water points until the max level is hit.
     Parameters: an integer
     Returns: void
     */
    public void addWaterLevel(int waterAdded){
        accessedPlant.setWaterLevel(accessedPlant.getWaterLevel() + waterAdded);
        if(accessedPlant.getWaterLevel() >= accessedPlant.getMaxWaterLevel()){

            if(accessedPlant.getGrowthLevel() < accessedPlant.getMaxGrowthLevel()) {

                accessedPlant.setGrowthLevel(accessedPlant.getGrowthLevel()+1);

                accessedPlant.setWaterLevel( accessedPlant.getWaterLevel() - accessedPlant.getMaxWaterLevel());
            }
        }
    }


}
