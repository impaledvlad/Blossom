package bruteforce.presentation;

import android.app.Service;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bruteforce.blossom.R;



import bruteforce.business.AccessTask;
import bruteforce.application.Services;


public class SummaryActivity extends AppCompatActivity {
    AccessTask tasks;
    /**
     onCreate

     Purpose: setup Summary UI. Calls the methods to set total, completed and incomplete tasks.
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        tasks = new AccessTask(Services.getAccount().getUsername());

        setTextAllTasks();
        setTextCompleted();
    }
    /**
     setTextAllTasks

     Purpose: sets the text view for total tests.
     Parameters: none
     Returns: none
     */
    private void setTextAllTasks(){
        TextView all = findViewById(R.id.text_all);
        int total = tasks.getTaskList().size();
        all.setText(Integer.toString(total));
    }
    /**
     setTextCompleted

     Purpose: set text view for both complete and incomplete tasks.
     Parameters: none
     Returns: none
     */
    private void setTextCompleted(){
        TextView complete = findViewById(R.id.textview_completed);
        TextView incomplete = findViewById(R.id.textview_incomplete);

        int total = tasks.getTaskList().size();

        int completed_count = 0;
        int incomplete_count = 0;
    //loop through all the tasks,
        for (int i = 0; i<total;i++){
            //check if it's completed or not, then increment the appropriate count.
            if (tasks.getTaskList().get(i).getCompleted()) {
                completed_count++;
            }else{
                    incomplete_count++;
                }
        }
        //set the text items
        incomplete.setText(Integer.toString(incomplete_count));
        complete.setText(Integer.toString(completed_count));
    }

}
