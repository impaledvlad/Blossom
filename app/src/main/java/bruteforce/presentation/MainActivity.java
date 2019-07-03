package bruteforce.presentation;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bruteforce.blossom.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


import bruteforce.application.Main;
import bruteforce.business.AccessAccount;
import bruteforce.business.AccessTask;
import bruteforce.business.StringConverter;
import bruteforce.objects.Task;

/**
 Class: MainActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for main page
 */
public class MainActivity extends AppCompatActivity {
    //fields
    private AccessAccount accounts;
    private AccessTask tasks;
    private Task testTask;
    private StringConverter converter;

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
        copyDatabaseToDevice();

        converter = new StringConverter();
        tasks = new AccessTask("username1");
        final List<Task> taskDetails = tasks.getTaskList();
        //create new AccessTask with "username1" and get list of tasks of username1

        final ArrayAdapter<Task> taskArrayAdapter = new ArrayAdapter<Task>(
                this, android.R.layout.simple_list_item_2, android.R.id.text1, taskDetails) {
            //create ArrayAdapter to implement sub-item in ListView

            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position,convertView,parent);

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

        ListView listView = findViewById(R.id.list1);
        listView.setAdapter(taskArrayAdapter);
        //Implement above adapter into ListView in activity_main.xml

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //check which item in ListView is clicked

                Intent intent = new Intent(MainActivity.this, ShowTaskActivity.class);
                Task test = taskArrayAdapter.getItem(position);
                intent.putExtra("key", test);
                //intent.putExtra("user","username1");
                MainActivity.this.startActivity(intent);
                //Move to ShowTaskActivity to get more task options
            }
        });

        final Button addToTask = (Button) findViewById(R.id.button);
        //create Button object to handle Add new task button in activity_main.xml

        addToTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //these codes will be executed when Add new task button is clicked

                try {
                    String userName = "username1";
                    Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                    intent.putExtra("key",userName);
                    //pass username to AddTaskActivity

                    MainActivity.this.startActivity(intent);
                    //start AddTaskActivity

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //create Button object for Add new task button in activit_main.xml, it will
        //has a function to move from Main page to Add Task page. Intent object is used to transform
        //from one page to another page

        final Button completeTaskList = (Button) findViewById(R.id.button4) ;

        completeTaskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String userName = "username1";
                    Intent intent = new Intent(MainActivity.this, ShowCompletedTaskActivity.class);
                    intent.putExtra("key", userName);
                    MainActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     onCreateOptionsMenu

     Purpose: setup default menu
     Parameters: Menu menu
     Returns: boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    private void copyDatabaseToDevice() {
        final String DB_PATH = "db";

        String[] assetNames;
        Context context = getApplicationContext();
        File dataDirectory = context.getDir(DB_PATH, Context.MODE_PRIVATE);
        AssetManager assetManager = getAssets();

        try {

            assetNames = assetManager.list(DB_PATH);
            for (int i = 0; i < assetNames.length; i++) {
                assetNames[i] = DB_PATH + "/" + assetNames[i];
            }

            copyAssetsToDirectory(assetNames, dataDirectory);

            Main.setDBPathName(dataDirectory.toString() + "/" + Main.getDBPathName());

        } catch (final IOException ioe) {
            Messages.warning(this, "Unable to access application data: " + ioe.getMessage());
        }
    }

    public void copyAssetsToDirectory(String[] assets, File directory) throws IOException {
        AssetManager assetManager = getAssets();

        for (String asset : assets) {
            String[] components = asset.split("/");
            String copyPath = directory.toString() + "/" + components[components.length - 1];

            char[] buffer = new char[1024];
            int count;

            File outFile = new File(copyPath);

            if (!outFile.exists()) {
                InputStreamReader in = new InputStreamReader(assetManager.open(asset));
                FileWriter out = new FileWriter(outFile);

                count = in.read(buffer);
                while (count != -1) {
                    out.write(buffer, 0, count);
                    count = in.read(buffer);
                }

                out.close();
                in.close();
            }
        }
    }


}
