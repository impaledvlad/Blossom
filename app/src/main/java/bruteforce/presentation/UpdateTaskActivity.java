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

import com.bruteforce.blossom.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import bruteforce.business.AccessTask;
import bruteforce.business.DateValidation;
import bruteforce.business.StringConverter;
import bruteforce.objects.Task;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 Class: UpdateTaskActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for update task page
 */
public class UpdateTaskActivity extends AppCompatActivity {
    //fields
    boolean selection;
    private int daySelect;
    private int monthSelect;
    private int yearSelect;
    private StringConverter converter;
    private DateValidation validation;
    private AccessTask accessTask;
    private Task showTask;
    private Task taskInlist;
    private TextView mDate;
    private TextView showDateChosen;
    private TextView description;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private static final String TAG = "UpdateTaskActivity";

    /**
     onCreate

     Purpose: setup everything for UpdateTaskActivity page
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
        //set this activity to handle activity_update_task.xml

        converter = new StringConverter();
        Intent i = getIntent();
        accessTask = new AccessTask("username1");
        showTask = (Task) i.getSerializableExtra("key");
        //get username information from last activity

        taskInlist = accessTask.getTask(showTask.getTaskID());

        selection = false;
        validation = new DateValidation();



        description = (TextView) findViewById(R.id.editText2);
        description.setText(showTask.getName());

        RadioButton button1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton button2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton button3 = (RadioButton) findViewById(R.id.radioButton3);
        //setup radio button

        int priority = showTask.getPriority();
        if (priority == 0){
            //if priority in Task object is Low, set checkbox to true
            button1.setChecked(true);
        } else if (priority == 1) {
            //if priority in Task object is Medium, set checkbox to true
            button2.setChecked(true);
        } else if (priority == 2) {
            //if priority in Task object is Low, set checkbox to true
            button3.setChecked(true);
        }

        TextView dateShown = (TextView) findViewById(R.id.editText3);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MMM/dd", Locale.CANADA);
        String dateStr = dateFormat.format(showTask.getDeadline());
        dateShown.setText(dateStr);
        //setup for showing deadline of Task object

        mDate =(TextView) findViewById(R.id.textView7);
        showDateChosen = (TextView) findViewById(R.id.editText3);

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
                        UpdateTaskActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        yearSelect,monthSelect,daySelect);
                //setup calendar structure

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //show calendar dialog into activity_add_task


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
                String dateStr = year + "/" + month + "/" + dayOfMonth;
                //create a format string for displaying date

                showDateChosen.setText(dateStr);
                //set blank TextView to show date
            }
        };

        final Button updateTask = (Button) findViewById(R.id.button6);
        updateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rateGroup = (RadioGroup) findViewById(R.id.rateGroup1);
                int selectedButton = rateGroup.getCheckedRadioButtonId();
                //RadioGroup is used to select priority


                EditText descriptionText = (EditText) findViewById(R.id.editText2);
                String descriptionStr = descriptionText.getText().toString();
                //Text input for task desciption

                RadioButton priorityNumber = (RadioButton) findViewById(selectedButton);
                String priorityName = priorityNumber.getText().toString();
                //Find which radio button clicked

                int priority = converter.getPriorityInt(priorityName);

                accessTask.updateName(descriptionStr);
                accessTask.updatePriority(priority);
                if (!validation.validateDate(yearSelect, monthSelect, daySelect)) {
                    Date correctDate = new Date(yearSelect + "/" + monthSelect + "/" + daySelect);
                    accessTask.updateDeadline(correctDate);
                }

                accessTask.updateTask();
                //Do update all things here
                Intent testIntent = new Intent(UpdateTaskActivity.this, MainActivity.class);
                testIntent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(testIntent);
                //Return back to MainActivity

            }
        });
    }

    /**
     buttonCancelClick

     Purpose: return to MainActivity if user don't want to update
     Parameters: View v
     Returns: none
     */
    public void buttonCancelClick(View v) {
        Intent testIntent = new Intent(UpdateTaskActivity.this, MainActivity.class);
        testIntent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(testIntent);
    }

}
