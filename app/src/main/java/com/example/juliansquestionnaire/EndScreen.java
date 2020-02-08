package com.example.juliansquestionnaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class EndScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        Button restart = findViewById(R.id.btnRestart);

        Intent getIntent = new Intent();
        Intent getIntent2 = new Intent();

        String result = getIntent.getStringExtra("STR_ID");
        ArrayList<String> result2 = getIntent2.getStringArrayListExtra("ANSWERS");
        System.out.println(result + result2);

        restart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(EndScreen.this,com.example.juliansquestionnaire.MainActivity.class);
        startActivity(intent);
    }
}
