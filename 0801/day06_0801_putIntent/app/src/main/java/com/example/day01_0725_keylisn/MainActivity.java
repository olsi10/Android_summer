package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtAge;
    Button btn;
    CheckBox chkGame, chkMusic, chkEx;

    String name;
    int age;

    ArrayList <String> hobby = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        btn = findViewById(R.id.btn);
        chkGame = findViewById(R.id.chkGame);
        chkMusic = findViewById(R.id.chkMusic);
        chkEx = findViewById(R.id.chkEx);

        chkGame.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    hobby.add(chkGame.getText().toString());
                } else {
                    hobby.remove(hobby.indexOf(chkGame.getText().toString()));
                }
            }
        });

        chkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    hobby.add(chkMusic.getText().toString());
                } else {
                    hobby.remove(hobby.indexOf(chkMusic.getText().toString()));
                }
            }
        });

        chkEx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    hobby.add(chkEx.getText().toString());
                } else {
                    hobby.remove(hobby.indexOf(chkEx.getText().toString()));
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                try {
                    age = Integer.parseInt(edtAge.getText().toString());
                }
                catch (Exception e) {}
                Intent in = new Intent(getApplicationContext(), ReusltActivity.class);
                in.putExtra("age", age);
                in.putExtra("name", name);
                in.putExtra("hobby", hobby);
                startActivity(in);
            }
        });

    }
}