package com.example.juliansquestionnaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText date;
    EditText name;
    Intent putIntent;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btnStart = findViewById(R.id.btnStart);
        date = findViewById(R.id.etDate);
        name = findViewById(R.id.etName);

        putIntent = new Intent(MainActivity.this,com.example.juliansquestionnaire.EndScreen.class);
        intent = new Intent(MainActivity.this,com.example.juliansquestionnaire.MainScreen.class);

        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(!date.getText().toString().isEmpty() && !name.getText().toString().isEmpty()){

            String id = date.getText().toString() +" "+ name.getText().toString();

            putIntent.putExtra("STR_ID",id);

            startActivity(intent);

        }else Toast.makeText(this, "Please fill out the boxes", Toast.LENGTH_SHORT).show();


    }
}




/*
1. Design XML for start Screen
 Create 1 Button; one Button is "Start Questionnaire" -> this button will be disable till you fill up
 Date of Birth and  Last Name.
 Do a String called ID Date of Birth and Last Name
 String ID = 06072007Rees


 2. Design XML for Main Screen
  Create 1 TextView -> Display the question
  Create 1 Plain Text -> User's Answer
  Create 1 Button  -> Move "Forward" to next Question. (Last question is gonna say "Save" instead "Forward").
2. Coding: create an array with all questions(4 questions).
3. Coding: Create an array for save all answers.
4. Coding: Display first position of question array, then second..
5. Every time we click forward, we gonna save the answer in the answer's array.
Do a test, with only 4 questions.

When we click save in the last Question, we need to save the current Date (time temporary)


Create an object called Questionnaire
Array of Question
Array of Answer
Date of answer
User ID
 */