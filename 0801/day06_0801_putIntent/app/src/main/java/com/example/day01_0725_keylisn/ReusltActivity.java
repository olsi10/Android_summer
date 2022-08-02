package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ReusltActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuslt);


        txt = findViewById(R.id.txt);

        Intent in = getIntent();

        String name = in.getStringExtra("name");
        int age=  in.getIntExtra("age", 0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");

        txt.setText("이름 : " + name + "\n나이 : " + age + "\n취미 : ");

        for(String h:hobby) {
            txt.setText(txt.getText().toString() + h);
        }
    }
}