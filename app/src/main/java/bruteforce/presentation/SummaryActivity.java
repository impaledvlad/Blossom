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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        tasks = new AccessTask(Services.getAccount().getUsername());

        setTextAllTasks();
        setTextCompleted();
    }

    private void setTextAllTasks(){
        TextView all = findViewById(R.id.text_all);
        int total = tasks.getTaskList().size();
        all.setText(Integer.toString(total));
    }
    private void setTextCompleted(){
        TextView complete = findViewById(R.id.textview_completed);
        TextView incomplete = findViewById(R.id.textview_incomplete);

        int total = tasks.getTaskList().size();

        int completed_count = 0;
        int incomplete_count = 0;

        for (int i = 0; i<total;i++){
            if (tasks.getTaskList().get(i).getCompleted()) {
                completed_count++;
            }else{
                    incomplete_count++;
                }
        }

        incomplete.setText(Integer.toString(incomplete_count));
        complete.setText(Integer.toString(completed_count));
    }

}
