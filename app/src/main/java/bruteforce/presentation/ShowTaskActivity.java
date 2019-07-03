package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.bruteforce.blossom.R;

import bruteforce.business.AccessAccount;
import bruteforce.application.Services;
import bruteforce.business.AccessTask;
import bruteforce.business.CalculatePoints;
import bruteforce.objects.Task;

/**
 Class: ShowTaskActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for ShowTask page
 */
public class ShowTaskActivity extends AppCompatActivity {
    //fields
    AccessAccount accessAccount;
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
        accessAccount = new AccessAccount(holder);

        //holder = "username1";
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
     onBackPressed

     Purpose: setup soft back button for ShowTask page
     Parameters: none
     Returns: none
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent test = new Intent(ShowTaskActivity.this, MainActivity.class);
        test.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(test);
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
            //doTask.setCompleted(true);
            CalculatePoints tempCalculate = new CalculatePoints(accessAccount, accessTask);
            tempCalculate.awardPoints();
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
        Toast showInfo = Toast.makeText(getBaseContext(),"Deleted successfully",Toast.LENGTH_LONG);
        showInfo.show();
        NavUtils.navigateUpFromSameTask(this);


    }
}
