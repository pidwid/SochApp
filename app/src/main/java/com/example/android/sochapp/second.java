package com.example.android.sochapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

public class second extends AppCompatActivity {

    //accepting name
    String nameText = ApplicationSessionStorage.GetSessionData("Name");
    //accepting age
    String ageText = ApplicationSessionStorage.GetSessionData("Age");
    //accepting email
    String emailText = ApplicationSessionStorage.GetSessionData("Email");
    //accepting mobile
    String mobileText = ApplicationSessionStorage.GetSessionData("Mobile");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void Submission(View view) {

        try {

            Intent i = new Intent(this, thankyouPage.class);
            startActivity(i);


            //if user selects toys
            CheckBox toys = findViewById(R.id.toys);
            boolean toysChecked = toys.isChecked();

            //if user selects Footware
            CheckBox footwear = findViewById(R.id.footwear);
            boolean footwearChecked = footwear.isChecked();

            //if user selects clothes
            CheckBox clothes = findViewById(R.id.clothes);
            boolean clothesChecked = clothes.isChecked();

            //if user selects books
            CheckBox book = findViewById(R.id.books);
            boolean bookChecked = book.isChecked();

            //if user selects food
            CheckBox food = findViewById(R.id.food);
            boolean foodChecked = food.isChecked();

            //if user selects stationary
            CheckBox stationary = findViewById(R.id.Stationary);
            boolean stationaryChecked = stationary.isChecked();

            //For other text name
            EditText otherField = findViewById(R.id.other);
            String otherText = otherField.getText().toString();

            String message = summary(toysChecked, foodChecked, clothesChecked, bookChecked, foodChecked, stationaryChecked, otherText);


//Intent
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "kanikajoshi0308@gmail.com", null));
            intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.donation_subject) + ": " + nameText);
            intent.putExtra(intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            Toast.makeText(this, "Submitted Successfully!!!", Toast.LENGTH_LONG).show();

        } catch (Exception e) {

            Toast.makeText(this, "Please fill details", Toast.LENGTH_SHORT).show();
        }
    }


    private String summary(boolean toysChecked,boolean foodChecked,boolean clothesChecked,
                           boolean bookChecked,boolean footwearChecked,boolean stationaryChecked,String otherText){
        String message =  "I " + nameText + ", ";
        message += getResources().getString(R.string.age)+ " " + ageText + " ";
        message += getResources().getString(R.string.email)+ " " + emailText + " ";
        message += getResources().getString(R.string.mobile)+ " " + mobileText + " ";
        message += getResources().getString(R.string.donate)+ " : ";
        message += "\n" + "\n" +getResources().getString(R.string.toys)+ "  " + toysChecked;
        message += "\n" +getResources().getString(R.string.footwear)+ "  " + footwearChecked;
        message += "\n" +getResources().getString(R.string.clothes)+ "  " + clothesChecked;
        message += "\n" +getResources().getString(R.string.books)+ "  " + bookChecked;
        message += "\n" +getResources().getString(R.string.food)+ "  " + foodChecked;
        message += "\n" +getResources().getString(R.string.stationary)+ "  " + stationaryChecked;
        message += "\n" + "and " + otherText + ".";
        message += "\n" + "\n" +getResources().getString(R.string.last);
        message += "\n" +getResources().getString(R.string.thank);
        return message;

    }

}
