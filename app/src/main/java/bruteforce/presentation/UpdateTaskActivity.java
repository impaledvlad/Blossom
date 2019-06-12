package bruteforce.presentation;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
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

import java.util.Calendar;
import java.util.Date;

import bruteforce.business.AccessTask;
import bruteforce.business.DateValidation;
import bruteforce.objects.Task;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class UpdateTaskActivity extends AppCompatActivity {
    boolean selection;
    private int daySelect;
    private int monthSelect;
    private int yearSelect;
    private DateValidation validation;
    private AccessTask accessTask;
    private Task showTask;
    private Task taskInlist;
    private TextView mDate;
    private TextView showDateChosen;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private static final String TAG = "UpdateTaskActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);

        Intent i = getIntent();
        accessTask = new AccessTask("username1");
        showTask = (Task) i.getSerializableExtra("key");

        taskInlist = accessTask.getTask(showTask.getTaskID());

        selection = false;
        validation = new DateValidation();



        TextView description = (TextView) findViewById(R.id.editText2);
        description.setText(showTask.getName());

        RadioButton button1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton button2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton button3 = (RadioButton) findViewById(R.id.radioButton3);

        int priority = showTask.getPriority();
        if (priority == 0){
            button1.setChecked(true);
        } else if (priority == 1) {
            button2.setChecked(true);
        } else if (priority == 2) {
            button3.setChecked(true);
        }

        TextView dateShown = (TextView) findViewById(R.id.editText3);
        String dateStr = showTask.getDeadline().getYear()+"/"+showTask.getDeadline().getMonth()+"/"+showTask.getDeadline().getDate();
        dateShown.setText(dateStr);

        mDate =(TextView) findViewById(R.id.textView7);

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

                //selection = true;

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

        final Button updateTask = (Button) findViewById(R.id.button6);
        updateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rateGroup = (RadioGroup) findViewById(R.id.rateGroup1);
                int selectedButton = rateGroup.getCheckedRadioButtonId();
                //RadioGroup is used to select priority

                //if (selection) {
                    //check to one of three radio button is clicked or not

                    EditText descriptionText = (EditText) findViewById(R.id.editText2);
                    String description = descriptionText.getText().toString();
                    //Text input for task desciption

                    RadioButton priorityNumber = (RadioButton) findViewById(selectedButton);
                    String priorityName = priorityNumber.getText().toString();
                    //Find which radio button clicked

                    int priority;
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

                    //if (!validation.validateDate(yearSelect, monthSelect, daySelect)) {
                        //check date which user select, if date is not valid, user cannot proceed any further

                        //Date testDate = new Date(yearSelect, monthSelect, daySelect);
                        //Task testTask = new Task(description, holder.getUsername(), testDate, false, priority);

                        accessTask.updateName(description);
                        accessTask.updatePriority(priority);
                        accessTask.updateTask();
                        //create a new task and add it

                        Intent testIntent = new Intent(UpdateTaskActivity.this, MainActivity.class);
                        //testIntent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(testIntent);


                   // }
                //}
            }
        });
    }

}
