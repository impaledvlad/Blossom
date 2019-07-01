package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import com.bruteforce.blossom.R;

import bruteforce.application.Services;
import bruteforce.business.AccessTask;
import bruteforce.objects.Task;

/**
 Class: ShowTaskActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for ShowTask page
 */
public class ShowTaskActivity extends AppCompatActivity {
    //fields
    AccessTask accessTask;
    Task showTask;
    Task doTask;
    String holder;

    /**
     onCreate

     Purpose: setup everything for ShowTask page
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_task);
        //set this activity to handle activity_show_task.xml

        Intent intent = getIntent();
        holder = Services.getAccount().getUsername();
        accessTask = new AccessTask(holder);
        showTask = (Task)intent.getSerializableExtra("key");
        doTask = accessTask.getTask(showTask.getTaskID());
        //get data passed from MainActivity
        CheckBox testBox = (CheckBox) findViewById(R.id.checkBox);
        if (doTask.getCompleted()) {
            testBox.setChecked(true);
        }
    }

    /**
     checkBoxClick

     Purpose: mark that task is completed
     Parameters: View v
     Returns: none
     */
    public void checkBoxClick(View v) {
        CheckBox finishBox = (CheckBox) findViewById(R.id.checkBox);
        if (finishBox.isChecked()) {
            doTask.setCompleted(true);
        } else {
            doTask.setCompleted(false);
        }
    }
    /**
     buttonModifyOnClick

     Purpose: transfer to UpdateTaskActivity when pressing Modify button
     Parameters: View v
     Returns: none
     */
    public void buttonModifyOnClick(View v) {
        Intent modify = new Intent(ShowTaskActivity.this,UpdateTaskActivity.class);
        modify.putExtra("key",showTask);
        //modify.putExtra("user",holder);
        ShowTaskActivity.this.startActivity(modify);
    }

    /**
     buttonDeleteOnClick

     Purpose: delete selected task when pressing Delete button
     Parameters: View v
     Returns: none
     */
    public void buttonDeleteOnClick(View v) {
        accessTask.deleteTask();
        NavUtils.navigateUpFromSameTask(this);


    }
}
