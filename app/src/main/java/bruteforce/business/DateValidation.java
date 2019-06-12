package bruteforce.business;

import java.util.Calendar;

/**
 Class: DateValidation
 Author: Triet Nguyen
 Purpose: To check for valid date when inserting new task, AddTaskActivity cannot proceed further if
        it does not pass this test.
 */

public class DateValidation {

    /**
     validateDate

     Purpose: validate date
     Parameters: int year, int month, int day
     Returns: boolean
     */

    public boolean validateDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        boolean error = false;
        if (year < cal.get(Calendar.YEAR)) {
            error = true;
        } else if (year == cal.get(Calendar.YEAR) && month < cal.get(Calendar.MONTH) + 1) {
            error = true;
        } else if (year == cal.get(Calendar.YEAR) && month == cal.get(Calendar.MONTH) + 1 && day < cal.get(Calendar.DATE)) {
            error = true;
        }
        return error;
    }
}
