package bruteforce.business;

/**
 Class: StringConverter
 Author: Triet Nguyen
 Purpose: To convert information get from Task object into string and display it
 */

public class StringConverter {

    /**
     getCompletionString

     Purpose: return a string when user check the box
     Parameters: boolean done
     Returns: String
     */
    public String getCompletionString(boolean done) {
        String checkCompletion = "";
        if (done) {
            checkCompletion = "Done";
        } else {
            checkCompletion = "Ongoing";
        }
        return checkCompletion;
    }

    /**
     getPriorityString

     Purpose: return a string when user choose priority
     Parameters: int num
     Returns: String
     */
    public String getPriorityString(int num) {
        String checkPriority = "";
        if (num == 0) {
            //if priority in Task object is 0, return Low
            checkPriority = "Low";
        } else if (num == 1) {
            //if priority in Task object is 1, return Medium
            checkPriority = "Medium";
        } else {
            //if priority in Task object is 2, return High
            checkPriority = "High";
        }
        return checkPriority;
    }

    /**
     getPriorityInt

     Purpose: return a integer when user choose priority
     Parameters: String str
     Returns: int
     */
    public int getPriorityInt(String str) {
        int value;
        if (str.equals("Low")) {
            //priority is low
             value = 0;
        } else if (str.equals("Medium")) {
            //priority is medium
            value = 1;
        } else {
            //priority is high
            value = 2;
        }
        return value;
    }
}
