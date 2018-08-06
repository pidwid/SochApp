package com.example.android.sochapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submit_detail (View view){

        try {


            //For edit text name
            EditText nameField = findViewById(R.id.name);
            String nameText = nameField.getText().toString();

            //For edit text name
            EditText ageField = findViewById(R.id.age);
            String ageText = ageField.getText().toString();

            //For edit text name
            EditText emailField = findViewById(R.id.email);
            String emailText = emailField.getText().toString();

            //For edit text name
            EditText mobileField = findViewById(R.id.mobile);
            String mobileText = mobileField.getText().toString();

            //Sending Name value
            ApplicationSessionStorage.SetSessionData("Name", nameText);

            //Sending age value
            ApplicationSessionStorage.SetSessionData("Age", ageText);

            //Sending email value
            ApplicationSessionStorage.SetSessionData("Email", emailText);

            //Sending phone value
            ApplicationSessionStorage.SetSessionData("Mobile", mobileText);


            Intent i = new Intent(MainActivity.this, second.class);
            startActivity(i);

        }
        catch (Exception e) {

            Toast.makeText(this, "Please fill details", Toast.LENGTH_SHORT).show();
        }

    }
}