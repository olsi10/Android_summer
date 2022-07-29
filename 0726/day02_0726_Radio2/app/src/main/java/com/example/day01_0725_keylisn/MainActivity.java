package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rose, pansi, white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 실습");

        rg = findViewById(R.id.rg);
        rose = findViewById(R.id.rose);
        pansi = findViewById(R.id.pansi);
        white = findViewById(R.id.white);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rose:
                        Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show();
                    case R.id.pansi:
                        Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show();
                    case R.id.white:
                        Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}