package bruteforce.business;

import bruteforce.objects.Plant;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccessPlantTest {

    /**
     Author: Ahmed Kidwai
     testAccessPlantConstructor
     Purpose: test  constructor of AccessPlant class.
     Parameters: none.
     Returns: none.
     */

    @Test
    public void testAccessPlantConstructor() {

        System.out.println("\nStarting testAccessPlantConstructor");

        Plant plant = new Plant(13);
        AccessPlant currPlant = new AccessPlant(plant);

        assertNotNull("This AccessPlant Object Should Not Be NULL", currPlant);
        System.out.println("Finished testAccessPlantConstructor");

    }


    /**
     Author: Ahmed Kidwai
     testGetCurrentPlant
     Purpose: test  constructor of AccessPlant class.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void testGetCurrentPlant() {

        System.out.println("\nStarting testGetCurrentPlant");

        Plant plant = new Plant(4);
        AccessPlant currPlant = new AccessPlant(plant);




        assertNotNull("This AccessPlant Object Should Not Be NULL", currPlant);
        assertEquals("This Should 13", 4, currPlant.getCurrentPlant().getGrowthLevel());

        System.out.println("Finished testGetCurrentPlant");


    }
    @Test
    public void testAddWaterLevel(){
        System.out.println("\nStarting testAddWaterLevel");

        Plant plant = new Plant(10, 3);
        AccessPlant currPlant = new AccessPlant(plant);

        //add one full water level (default is 100)
        currPlant.addWaterLevel(currPlant.getCurrentPlant().getMaxWaterLevel());

        assertEquals("Growth level should be 4", 4, currPlant.getCurrentPlant().getGrowthLevel());
        assertEquals("Water Level should be 10", 10, currPlant.getCurrentPlant().getWaterLevel());

        System.out.println("Finished testAddWaterLevel");


    }



    }
