package com.example.juliansquestionnaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    int i = 0;
    TextView question;
    EditText answer;
    ArrayList<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        answer = findViewById(R.id.etAnswer);
        question = findViewById(R.id.tvQuestion);
        Button next = findViewById(R.id.btnNext);

        questions(i);



        next.setOnClickListener(this);

    }
     public String questions(int position){
        String[] ask = {"What is your idea of perfect happiness?", "What is your greatest fear?", "What is the trait you most deplore in yourself?", "What is the trait you most deplore in others?"};


        question.setText(ask[position]);



        if(!answer.getText().toString().equalsIgnoreCase("")){
            answers.add(answer.getText().toString());
            System.out.println(answers);
            answer.setText("");
        }else Toast.makeText(this, "Please fill out the answer", Toast.LENGTH_SHORT).show();

        return ask[position];
    }

    @Override
    public void onClick(View v) {
        i++;
        if (i == 4) {
            Intent intent = new Intent(MainScreen.this, com.example.juliansquestionnaire.EndScreen.class);
            intent.putExtra("ANSWERS", answers);
            startActivity(intent);
        } else questions(i);
    }
}
