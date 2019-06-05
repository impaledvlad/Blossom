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
        Plant plant;
        System.out.println("\nStarting testPlantFirstConstructor");

        plant = new Plant();
        assertNotNull("plant object should not be null",plant);
        assertEquals("initial value must be 0",0,plant.getGrowthLevel());

        System.out.println("\nFinished testPlanFirstConstructor");
    }

    /**
     testPlantSecondConstructor

     Purpose: test second constructor of Plant class, this constructor has three parameters
     Parameters: none
     Returns: none, must print out finished to pass the test
     */

    @Test
    public void testPlantSecondConstructor() {
        Plant plant;
        System.out.println("\nStarting testSecondConstructor");

        plant = new Plant(13);
        assertNotNull("plant object should not be null",plant);
        assertEquals("plant growth level is not correct",13,plant.getGrowthLevel());

        System.out.println("\nFinished testSecondConstructor");
    }
}
