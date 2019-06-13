package bruteforce.business;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StringConverterTest {

    /**
     Class: StringConverterTest
     Author: Ahmed Kidwai
     Purpose: Check to see the StringConverter actually returns strings.
     */


    /**
     getCompletionString

     Purpose: return a string when user check the box
     Parameters: boolean done
     Returns: String
     */
    @Test
    public void testGetCompletionString() {
        System.out.println("\nTesting GetCompletionString");
        StringConverter isTrue = new StringConverter();
        StringConverter isFalse = new StringConverter();
        String result = "";

        result = isFalse.getCompletionString(true);
        assertEquals("", result, "Done");

        result = isTrue.getCompletionString(false);
        assertEquals("", result, "Ongoing");
        System.out.println("Finished TestCompletingString");
    }

    /**
     testGetPriorityInt

     Purpose: Taking a priority string and returning an int.
     Parameters: None
     Returns: Void
     */
    @Test
    public void testGetPriorityInt() {
        System.out.println("\nTesting testGetPriorityInt");
        StringConverter isLow = new StringConverter();
        StringConverter isMedium = new StringConverter();
        StringConverter isHigh = new StringConverter();

        int priority = 0;
        priority = isLow.getPriorityInt("Low");
        assertEquals("This is a low priority", priority, 0);

        priority = isMedium.getPriorityInt("Medium");
        assertEquals("This is a medium priority", priority, 1);

        priority = isHigh.getPriorityInt("High");
        assertEquals("This is a high priority", priority, 2);


        System.out.println("Finished testGetPriorityInt");
    }


    /**
     testGetPriorityString

     Purpose: Taking a priority string and returning an int.
     Parameters: None
     Returns: Void
     */
    @Test
    public void testGetPriorityString() {
        System.out.println("\nTesting testGetPriorityString");
        StringConverter isZero = new StringConverter();
        StringConverter isOne = new StringConverter();
        StringConverter isTwo = new StringConverter();

        String priority = "";
        priority = isZero.getPriorityString(0);
        assertEquals("This is a low priority", priority, "Low");

        priority = isOne.getPriorityString(1);
        assertEquals("This is a medium priority", priority, "Medium");

        priority = isTwo.getPriorityString(2);
        assertEquals("This is a high priority", priority,  "High");


        System.out.println("Finished testGetPriorityString");
    }




}
