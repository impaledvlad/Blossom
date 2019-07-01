package bruteforce.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bruteforce.blossom.R;

import java.io.Serializable;

import bruteforce.application.Services;
import bruteforce.business.AccessAccount;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 Class: AccountInfoActivity
 Author: Triet Nguyen
 Purpose: To set up front-end stuff for Account Info page
 */

public class AccountInfoActivity extends AppCompatActivity {
    private AccessAccount accessAccount;
    private String name;
    private String pass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        //show personal information
        name = Services.getAccount().getUsername();
        pass = Services.getAccount().getPassword();
        accessAccount = new AccessAccount(name);
        final EditText userText = (EditText) findViewById(R.id.editText7);
        final EditText passText = (EditText) findViewById(R.id.editText6);

        //update button handler
        userText.setText(name);
        passText.setText(pass);
        Button showInfo = (Button) findViewById(R.id.button10);
        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = userText.getText().toString();
                pass = passText.getText().toString();

                accessAccount.updateUsername(name);
                accessAccount.updatePassword(pass);

                Intent backIntent = new Intent(AccountInfoActivity.this, MainActivity.class);
                backIntent.setFlags(FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(backIntent);
            }
        });
    }
}
