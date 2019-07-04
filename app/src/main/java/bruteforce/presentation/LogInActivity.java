package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


import com.bruteforce.blossom.R;

import bruteforce.application.Main;
import bruteforce.application.Services;
import bruteforce.business.AccessAccount;
import bruteforce.objects.Account;

import static android.widget.Toast.*;

/**
 Class: LoginActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for Login page
 */

public class LogInActivity extends AppCompatActivity {
    private AccessAccount accessAccount;
    private String userName;
    private String password;
    private Account currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        copyDatabaseToDevice();

        accessAccount = new AccessAccount();

        //login button handler
        Button logIn = findViewById(R.id.button7);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userNameInput = findViewById(R.id.editText4);
                EditText passwordInput = findViewById(R.id.editText5);

                userName = userNameInput.getText().toString();
                password = passwordInput.getText().toString();
                if (userName.matches("") && password.matches("")) {
                    Toast text1 = Toast.makeText(getApplicationContext(),"You did not enter a username and a passowrd", LENGTH_SHORT);
                    text1.show();
                } else if (password.matches("")) {
                    Toast text2 = Toast.makeText(getApplicationContext(),"You did not enter a password",LENGTH_SHORT);
                    text2.show();
                } else if (userName.matches("")) {
                    Toast text3 = Toast.makeText(getApplicationContext(),"You did not enter a username",LENGTH_SHORT);
                    text3.show();
                } else if (!userName.matches("") && !password.matches("")) {
                    if(accessAccount.checkLogin(userName,password)) {

                        Account account = accessAccount.getCurrentAccount();
                        Services.setAccount(account);

                        Intent i = new Intent(LogInActivity.this, MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    } else {
                        Toast text4 = Toast.makeText(getApplicationContext(),"Invalid username or password",LENGTH_SHORT);
                        text4.show();
                    }
                }
            }
        });

        //sign up button handler
        Button register = (Button) findViewById(R.id.button9);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerTab = new Intent(LogInActivity.this, RegisterActivity.class);
                LogInActivity.this.startActivity(registerTab);
            }
        });
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
