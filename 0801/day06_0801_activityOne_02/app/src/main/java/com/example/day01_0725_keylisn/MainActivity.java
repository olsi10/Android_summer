package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb2, rb3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rg.getCheckedRadioButtonId() == R.id.rb2) {
                    Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(in);
                }
                else {
                    Intent in = new Intent(getApplicationContext(), ThirdActivity.class);
                    startActivity(in);
                }
            }
        });

    }
}