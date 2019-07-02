package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bruteforce.blossom.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import bruteforce.application.Services;
import bruteforce.business.AccessAccount;
import bruteforce.business.AccessTask;
import bruteforce.business.StringConverter;
import bruteforce.objects.Task;

/**
 Class: ShowCompletedActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for completed task page
 */

public class ShowCompletedTaskActivity extends AppCompatActivity {
    //fields
    private AccessAccount accounts;
    private AccessTask tasks;
    private Task testTask;
    private String userName;
    private StringConverter converter;

    /**
     onCreate

     Purpose: setup everything for ShowTask page
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_completed_task);
        //set this MainActivity to work activity_main.xml

        converter = new StringConverter();
        Intent i = getIntent();
        userName = Services.getAccount().getUsername();
        tasks = new AccessTask(userName);
        List<Task> tempList = tasks.getTaskList();
        final List<Task> taskDetails = new ArrayList<>();

        for (int j = 0; j < tempList.size(); j++) {
            if (tempList.get(j).getCompleted()) {
                taskDetails.add(tempList.get(j));
            }
        }

        //create new AccessTask with "username1" and get list of tasks of username1

        final ArrayAdapter<Task> taskArrayAdapter = new ArrayAdapter<Task>(
                this, android.R.layout.simple_list_item_2, android.R.id.text1, taskDetails) {
            //create ArrayAdapter to implement sub-item in ListView

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView text1 = view.findViewById(android.R.id.text1);
                //create TextView for text1 in simple_list_item
                TextView text2 = view.findViewById(android.R.id.text2);
                //create TextView for text2 in simple_list_item

                String checkCompletion = converter.getCompletionString(taskDetails.get(position).getCompleted());


                String checkPriority = converter.getPriorityString(taskDetails.get(position).getPriority());

                String text1Str = String.format("%s - %s - %s", taskDetails.get(position).getName(), checkPriority, checkCompletion);
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd", Locale.CANADA);
                String text2Str = dateFormat.format(taskDetails.get(position).getDeadline());

                //Make string format for text1 and text2

                text1.setText(text1Str);
                text2.setText(text2Str);
                //Set two strings to text1 and text2

                return view;

            }
        };

        ListView listView = findViewById(R.id.list2);
        listView.setAdapter(taskArrayAdapter);
        //Implement above adapter into ListView in activity_main.xml
    }
}
