package bruteforce.objects;

/**
Class: Plant
Author: John Manning
Purpose: An object for the Plant feature of our project. 
        Represents a plant that will be larger depending on the current growth level
*/

public class Plant {
    private int maxGrowthLevel = 5;
    private int growthLevel;
    private int waterLevel;

    public Plant() {
        this.growthLevel = 0;
        this.waterLevel = 0;
    }

    public Plant(int growthLevel) {
        this.growthLevel = growthLevel;
        this.waterLevel = 0;
    }

    public Plant(int waterLevel, int growthLevel){
        this.growthLevel = growthLevel;
        this.waterLevel = waterLevel;
    }

    /**
    getGrowthLevel

    Purpose: return the growthLevel of this plant object.
    Parameters: none
    Returns: an int
    */
    public int getGrowthLevel() {
        return growthLevel;
    }

    /** 
    setGrowthLevel

    Purpose: change the growthLevel of this plant object
    Parameters:  int newLevel
    Returns: void
    */
    public void setGrowthLevel(int newLevel){
        this.growthLevel = newLevel;
    }
    /**
     getWaterLevel

     Purpose: returns the current water level of the the plant. (This is a hidden value, the user can't see it)
     Parameters: void
     Returns: an integer
     */
    public int getWaterLevel(){
        return waterLevel;
    }
/**
 setWaterLevel

     Purpose: used to manually set the water level. currently unused
     Parameters: an integer.
     Returns: void
     */
    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getMaxGrowthLevel() {
        return maxGrowthLevel;
    }
}
