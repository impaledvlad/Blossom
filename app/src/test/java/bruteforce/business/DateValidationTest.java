package bruteforce.business;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 Class: testConstructor
 Author: Ahmed Kidwai
 Purpose: This function tests to see if a date is valid and it is in the future.
 */
public class DateValidationTest {

    /**
     testValidateDate

     Purpose: Checks to see that dates chosen are in the future.
     Parameters: None
     Returns: void
     */
    @Test
    public void testValidateDate() {

        System.out.println("\nTesting DateValidation");
        DateValidation test1 = new DateValidation();
        DateValidation test2 = new DateValidation();
        DateValidation test3 = new DateValidation();


        boolean result = true;

        //Test invalid date
        result = test1.validateDate(1992, 12, 33);
        assertTrue("Day is Invalid", result);


        // Test invalid month
        result = test2.validateDate(1992, 22, 23);
        assertTrue("Month is invalid", result);

        // Test future Date:
        result = test3.validateDate(2020, 12, 12);
        assertFalse("This date is valid", result);

        // Test past date:
        result = test3.validateDate(1992, 03, 03);
        assertTrue("Past dates cannot be used", result);

        System.out.println("DateValidation has run successfully");


    }

}
