package bruteforce.business;

import java.util.Calendar;

import bruteforce.business.Exceptions.DateException;

public class DateInputValidation {
    public void dateCheck(int year, int month, int day) throws DateException {
        Calendar cal = Calendar.getInstance();

        if (year < cal.get(Calendar.YEAR)) {
            throw new DateException("Year "+ year +" is in the past.");
        } else if (year == cal.get(Calendar.YEAR) && month < cal.get(Calendar.MONTH) + 1) {
            throw new DateException("Month" + month+ " is in the past.");
        } else if (year == cal.get(Calendar.YEAR) && month == cal.get(Calendar.MONTH) + 1 && day < cal.get(Calendar.DATE)) {
            throw new DateException("Day" + day +" is in the past.");
        }
    }
}
