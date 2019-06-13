package bruteforce.business;

public class StringConverter {

    public String getCompletionString(boolean done) {
        String checkCompletion = "";
        if (done) {
            checkCompletion = "Done";
        } else {
            checkCompletion = "Ongoing";
        }
        return checkCompletion;
    }

    public String getPriorityString(int num) {
        String checkPriority = "";
        if (num == 0) {
            checkPriority = "Low";
        } else if (num == 1) {
            checkPriority = "Medium";
        } else {
            checkPriority = "High";
        }
        return checkPriority;
    }

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
