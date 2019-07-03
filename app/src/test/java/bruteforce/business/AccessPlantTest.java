package bruteforce.business;

import bruteforce.objects.Plant;

import org.junit.Test;

import bruteforce.objects.Plant;
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

        Plant plant = new Plant(13);
        AccessPlant currPlant = new AccessPlant(plant);

        currPlant.getCurrentPlant();


        assertNotNull("This AccessPlant Object Should Not Be NULL", currPlant);
        assertEquals("This Should 13", 13, currPlant.getCurrentPlant().getGrowthLevel());

        System.out.println("Finished testGetCurrentPlant");


    }


    }
