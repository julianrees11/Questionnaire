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
        String[] ask = {"What is your idea of perfect happiness?", "What is your greatest fear?", "What is the trait you most deplore in yourself?", "What is the trait you most deplore in others?","Which living person do you most admire?","What is your greatest extravagance?","What is your current state of mind?","What do you consider the most overrated virtue?","On what occasion do you lie?","What do you most dislike about your appearance?","Which living person do you most despise?","What is the quality you most like in a man?","What is the quality you most like in a woman?14","Which words or phrases do you most overuse?","What or who is the greatest love of your life?","When and where were you happiest?","Which talent would you most like to have?","If you could change one thing about yourself, what would it be?","What do you consider your greatest achievement?","If you were to die and come back as a person or a thing, what would it b","Where would you most like to live?","What is your most treasured possession?","What do you regard as the lowest depth of misery?","What is your favorite occupation?","What is your most marked characteristic?","What do you most value in your friends?","Who are your favorite writers?","Who is your hero of action?","Which historical figure do you most identify with?","Who are your heroes in real life?","What are your favorite names?","What is it that you most dislike?","What is your greatest regret?","How would you like to die?","What is your motto"};
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
        if (i == 36) {
            Intent intent = new Intent(MainScreen.this, com.example.juliansquestionnaire.EndScreen.class);
            intent.putExtra("ANSWERS", answers);
            startActivity(intent);
        } else questions(i);
    }
}