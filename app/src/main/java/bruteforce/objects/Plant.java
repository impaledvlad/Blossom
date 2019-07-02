package bruteforce.objects;

/**
Class: Plant
Author: John Manning
Purpose: An object for the Plant feature of our project. 
        Represents a plant that will be larger depending on the current growth level
*/

public class Plant {
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

    public int getWaterLevel(){
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }
    public void addWaterLevel(int waterAdded){
        this.waterLevel += waterAdded;
        if(this.waterLevel >= 100){
            this.growthLevel++;
            this.waterLevel = this.waterLevel-100;
        }
    }

}