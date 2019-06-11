package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;


import com.bruteforce.blossom.R;

import java.util.ArrayList;
import java.util.List;

import bruteforce.business.AccessAccount;
import bruteforce.business.AccessTask;
import bruteforce.objects.Task;

/**
 Class: MainActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for main page
 */

public class MainActivity extends AppCompatActivity {
    private AccessAccount accounts;
    private AccessTask tasks;

    /**
     onCreate

     Purpose: setup everything for main page
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set this MainActivity to work activity_main.xml

        tasks = new AccessTask("username1");
        List<Task> taskDetails = tasks.getTaskList();
        //create new AccessTask with "username1" and get list of tasks of username1

        ArrayList<String> taskInfo = new ArrayList<>();
        for (int i = 0; i < taskDetails.size(); i++) {
            taskInfo.add("Name: "+taskDetails.get(i).getName()+", Priority: "+taskDetails.get(i).getPriority());
        }
        //create new arraylist of string to store one line of task information

        ListView taskListDisplay = (ListView) findViewById(R.id.list1);
        ListAdapter showInfo = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,taskInfo);
        taskListDisplay.setAdapter(showInfo);
        //ListView is used to display all element in a list, i set it to show each task information in list.


        final Button addToTask = (Button) findViewById(R.id.button);
        addToTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String userName = "username1";
                    Intent intent = new Intent(MainActivity.this,AddTaskActivity.class);
                    intent.putExtra("key",userName);
                    //pass username to AddTaskActivity

                    MainActivity.this.startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //create Button object for Add new task button in activit_main.xml, it will
        //has a function to move from Main page to Add Task page. Intent object is used to transform
        //from one page to another page

    }
    /**
     onCreateOptionsMenu

     Purpose: setup default menu
     Parameters: Menu menu
     Returns: boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    /**
    onOpTionsItemSelected

     Purpose: setup settings button on toolbar
     Parameters: MenuItem item
     Returns: boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
