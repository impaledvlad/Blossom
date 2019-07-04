package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bruteforce.blossom.R;

import bruteforce.business.AccessAccount;
import bruteforce.objects.Account;

/**
 Class: RegisterActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for Register page
 */
public class RegisterActivity extends AppCompatActivity {
    private AccessAccount accessAccount;
    private String username;
    private String password;

    /**
     onCreate

     Purpose: setup everything for Register page
     Parameters: Bundle savedInstanceState
     Returns: none
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        accessAccount = new AccessAccount();

        //register button handler
        Button register = (Button) findViewById(R.id.button10);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText userField = (EditText) findViewById(R.id.editText7);
                EditText passField = (EditText) findViewById(R.id.editText8);

                username = userField.getText().toString();
                password = passField.getText().toString();

                if (username.equals("") || password.equals("")) {
                    Toast text1 = Toast.makeText(getApplicationContext(),"Username or password is missing",Toast.LENGTH_SHORT);
                    text1.show();
                } else if (!username.equals("") && !password.equals("")) {
                    accessAccount.getAccount(username);
                    if (accessAccount.getCurrentAccount() == null) {
                        Account testAccount = new Account(username, password);
                        accessAccount.insertAccount(testAccount);
                        Intent backToLogin = new Intent(RegisterActivity.this, LogInActivity.class);
                        startActivity(backToLogin);


                        Toast showInfo = Toast.makeText(getBaseContext(), "Register successfully", Toast.LENGTH_LONG);
                        showInfo.show();
                        finish();
                    } else {
                        accessAccount.logOut();
                        Toast handler = Toast.makeText(getBaseContext(),"Account is already existed",Toast.LENGTH_SHORT);
                        handler.show();
                    }
                }

            }
        });
    }
}
