package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bruteforce.blossom.R;

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
                    if(accessAccount.getAccount(userName,password)) {

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
}
