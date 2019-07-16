package bruteforce.presentation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bruteforce.blossom.R;

import java.util.Calendar;
import java.util.Date;

import bruteforce.application.Services;
import bruteforce.business.AccessTask;
import bruteforce.business.DateValidation;
import bruteforce.business.StringConverter;
import bruteforce.objects.Task;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 Class: AddTaskActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for Add Task page
 */

public class AddTaskActivity extends AppCompatActivity {
    //fields
    private boolean chooseYet;
    private int daySelect;
    private int monthSelect;
    private int yearSelect;
    private StringConverter converter;
    private AccessTask taskListTest;
    private DateValidation validation;
    private TextView mDate;
    private TextView showDateChosen;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String userName;
    private int MAX_TASK = 10000;

    private static final String TAG = "AddTaskActivity";

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
        //set this Activity to handle activity_add_task.xml

        converter = new StringConverter();
        userName = Services.getAccount().getUsername();
        //get username from main page

        chooseYet = false;
        validation = new DateValidation();
        //create new DateValidation object

        taskListTest = new AccessTask(userName);
        //create new AccessTask object from received userName

        mDate = (TextView) findViewById(R.id.textView3);
        //set TestView of Deadline in activity_add_task
        showDateChosen = (TextView) findViewById(R.id.textView4);
        //set TextView for displaying chosen date in activity_add_task

        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //these codes will be executed when Deadline is clicked

                Calendar cal = Calendar.getInstance();
                yearSelect = cal.get(Calendar.YEAR);
                monthSelect = cal.get(Calendar.MONTH);
                daySelect = cal.get(Calendar.DAY_OF_MONTH);
                //get current date

                DatePickerDialog dialog = new DatePickerDialog(
                        AddTaskActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        yearSelect,monthSelect,daySelect);
                //setup calendar structure

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //show calendar dialog into activity_add_task

                chooseYet = true;

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //display chosen date in blank TextView
                month = month + 1;
                Log.d(TAG,"date has been set");

                yearSelect = year;
                monthSelect = month;
                daySelect = dayOfMonth;
                String selectDate = year + "/" + month + "/" + dayOfMonth;
                //create a format string for displaying date

                showDateChosen.setText(selectDate);
                //set blank TextView to show date
            }
        };

        final Button submitTaskInfo = (Button) findViewById(R.id.button3);
        //create Button object to handle Create button in activity_add_task.xml

        submitTaskInfo.setOnClickListener(new View.OnClickListener() {
            //these codes will be executed when Create button is clicked

            @Override
            public void onClick(View v) {
                //this function will control Create button what need to do

                RadioGroup rateGroup = (RadioGroup) findViewById(R.id.rateGroup);
                int selectedButton = rateGroup.getCheckedRadioButtonId();
                //RadioGroup is used to select priority

                if (chooseYet) {
                    //check to one of three radio button is clicked or not

                    EditText descriptionText = (EditText) findViewById(R.id.editText);
                    String description = descriptionText.getText().toString();
                    if (description.equals("")) {
                        openTaskDialog();
                    } else {
                        //Text input for task desciption

                        RadioButton priorityNumber = (RadioButton) findViewById(selectedButton);
                        String priorityName = priorityNumber.getText().toString();
                        //Find which radio button clicked

                        int priority = converter.getPriorityInt(priorityName);


                        if (!validation.validateDate(yearSelect, monthSelect, daySelect)) {
                            //check date which user select, if date is not valid, user cannot proceed any further

                            Date testDate = new Date(yearSelect + "/" + monthSelect + "/" + daySelect);
                            int taskId = (int)(Math.random()*MAX_TASK);
                            while(taskListTest.isExist(taskId))
                            {
                                taskId = (int)(Math.random()*MAX_TASK);
                            }
                            Task testTask = new Task(description, userName, testDate, false, taskId, priority);
                            taskListTest.insertTask(testTask);
                            //create a new task and add it

                            Intent testIntent = new Intent(AddTaskActivity.this, MainActivity.class);
                            //testIntent.putExtra("user",userName);
                            testIntent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(testIntent);

                            Toast infoTest = Toast.makeText(getBaseContext(), "Added successfully", Toast.LENGTH_LONG);
                            infoTest.show();
                        } else {
                            openDialog();
                        }
                    }
                }
            }
        });
        //this button is used for inserting new task
    }

    /**
     openDialog

     Purpose: create DateErrorDialog object to show
     Parameters: none
     Returns: none
     */
    public void openDialog() {
        DateErrorDialog errorDialog = new DateErrorDialog();
        errorDialog.show(getSupportFragmentManager(),"example dialog");
    }

    /**
     openDialog

     Purpose: create TitleErrorDialog object to show
     Parameters: none
     Returns: none
     */
    public void openTaskDialog() {
        TitleErrorDialog errorDialog = new TitleErrorDialog();
        errorDialog.show(getSupportFragmentManager(),"test dialog");
    }
}
