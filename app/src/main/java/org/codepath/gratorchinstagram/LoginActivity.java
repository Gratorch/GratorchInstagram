package org.codepath.gratorchinstagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG="LoginActivity";
    private EditText etUsename, etPassword;
    private Button btnLogin, btnSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsename=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnLogin=findViewById(R.id.btnLogin);
        btnSignin=findViewById(R.id.btnSign);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=etUsename.getText().toString();
                String password=etPassword.getText().toString();
                login(username,password);
            }
        });
    }
    public void login(String username, String password){
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e!=null){
                    //TODO : better error handling
                    Log.e(TAG,"Issue with login");
                    e.printStackTrace();
                    return;
                }
                //TODO : navigate to new activity if the user has signed properly
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {
        Intent i =new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}
