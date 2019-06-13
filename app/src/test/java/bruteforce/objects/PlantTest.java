package bruteforce.objects;

import org.junit.Test;

import bruteforce.objects.Plant;
import static org.junit.Assert.*;

/**
 Class: PlantTest
 Author: Triet Nguyen
 Purpose: This class tests Task object constructor and its accessor method
 */

public class PlantTest {

    /**
    testPlantFirstConstructor

    Purpose: test first constructor of Plant class, this constructor has no parameter
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testPlantFirstConstructor() {
        System.out.println("\nStarting testPlantFirstConstructor");

        Plant plant = new Plant();
        assertNotNull("Plant object should not be null", plant);
        assertEquals("Initial value must be 0",0, plant.getGrowthLevel());

        System.out.println("Finished testPlantFirstConstructor");
    }

    /**
    testPlantSecondConstructor

    Purpose: test second constructor of Plant class, this constructor has three parameters
    Parameters: none
    Returns: none, must print out finished to pass the test
    */
    @Test
    public void testPlantSecondConstructor() {
        System.out.println("\nStarting testPlantSecondConstructor");

        Plant plant = new Plant(13);
        assertNotNull("Plant object should not be null", plant);
        assertEquals("Plant growth level is not correct",13, plant.getGrowthLevel());

        System.out.println("Finished testPlantSecondConstructor");
    }
}