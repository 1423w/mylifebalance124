package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaCodec;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.inducesmile.androidmultiquiz.database.DBHandler;
import com.inducesmile.androidmultiquiz.database.DatabaseQuery;
import com.inducesmile.androidmultiquiz.entities.Client;
import com.inducesmile.androidmultiquiz.helper.MySharedPreference;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameET;
    private EditText emailET;
    private String name;
    private String email;
    private MySharedPreference sharedPreference;
    private DBHandler dbh;
    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.awadsdzx));

        dbh = new DBHandler(RegisterActivity.this);
        sharedPreference = new MySharedPreference(RegisterActivity.this);




        Button register = (Button) findViewById(R.id.register_button);
        assert register != null;
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameET = (EditText) findViewById(R.id.name);
                emailET = (EditText) findViewById(R.id.email);
                name = nameET.getText().toString();
                email = emailET.getText().toString();
                if(name.matches("") || email.matches("")) {
                    Toast.makeText(RegisterActivity.this, "You must enter both fields.", Toast.LENGTH_LONG).show();
                }
                if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {
                    Toast.makeText(RegisterActivity.this, "InValid Email Address.", Toast.LENGTH_LONG).show();
                }
                else {
                    client = new Client(name, email);
                    dbh.addClient(client);
                    sharedPreference.setSessionState(true);
                    Intent quizMenuIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
                    startActivity(quizMenuIntent);

                    Intent i = new Intent(RegisterActivity.this, QuizMenuActivity.class);
                    i.putExtra("user",name);
                    startActivity(i);
                }



            }
        });







        Button asGuest = (Button)findViewById(R.id.guest_button);
        assert asGuest != null;
        asGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizMenuIntent = new Intent(RegisterActivity.this, QuizMenuActivity.class);
                startActivity(quizMenuIntent);
            }
        });
    }
}


