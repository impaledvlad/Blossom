package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bruteforce.blossom.R;

import java.util.Date;

import bruteforce.business.AccessTask;
import bruteforce.objects.Task;

/**
 Class: AddTaskActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for Add Task page
 */

public class AddTaskActivity extends AppCompatActivity {
    private AccessTask taskListTest;

    /**
     onCreate

     Purpose: setup everything for Add task page
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Intent i = getIntent();
        final String userName = i.getStringExtra("key");
        //get username from main page

        taskListTest = new AccessTask(userName);

        final Button submitTaskInfo = (Button) findViewById(R.id.button3);
        submitTaskInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rateGroup = (RadioGroup) findViewById(R.id.rateGroup);
                int selectedButton = rateGroup.getCheckedRadioButtonId();
                //RadioGroup is used to select priority

                if (selectedButton != -1) {
                    EditText descriptionText = (EditText) findViewById(R.id.editText);
                    String description = descriptionText.getText().toString();
                    //Text input for task desciption

                    EditText dateText = (EditText) findViewById(R.id.editText4);
                    int date = Integer.parseInt(dateText.getText().toString());
                    //Text input for date

                    EditText monthText = (EditText) findViewById(R.id.editText5);
                    int month = Integer.parseInt(monthText.getText().toString());
                    //Text input for month

                    EditText yearText = (EditText) findViewById(R.id.editText6);
                    int year = Integer.parseInt(yearText.getText().toString());
                    //Text input for year

                    RadioButton priorityNumber = (RadioButton) findViewById(selectedButton);
                    String priorityName = priorityNumber.getText().toString();
                    //Find which radio button clicked

                    int priority = -1;
                    if (priorityName.equals("Low")) {
                        //priority is low
                        priority = 0;
                    } else if (priorityName.equals("Medium")) {
                        //priority is medium
                        priority = 1;
                    } else {
                        //priority is high
                        priority = 2;
                    }

                    Date testDate = new Date(year,month,date);
                    Task testTask = new Task(description,userName,testDate,false,priority);
                    taskListTest.insertTask(testTask);
                    //create a new task and add it

                    Intent result = new Intent(AddTaskActivity.this,MainActivity.class);
                    AddTaskActivity.this.startActivity(result);
                    finish();

                }
            }
        });
        //this button is used for inserting new task

    }


}
