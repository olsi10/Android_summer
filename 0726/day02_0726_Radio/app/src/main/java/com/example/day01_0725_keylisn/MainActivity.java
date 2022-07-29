package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton red, green, blue;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red = findViewById(R.id.red);
        green = findViewById(R.id.green);
        blue = findViewById(R.id.blue);
        group =findViewById(R.id.group);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                switch (checkID) {
                    case R.id.red :
                        Toast.makeText(getApplicationContext(), "red버튼클릭", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.green :
                        Toast.makeText(getApplicationContext(), "green Checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.blue :
                        Toast.makeText(getApplicationContext(), "blue Checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        

    }

    public void onRadioButtonClicked(View v) {
        boolean b = ((RadioButton)v).isChecked();
        
        if(b) {
            Toast.makeText(getApplicationContext(), ((RadioButton)v).getText().toString() + " 선택", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), ((RadioButton)v).getText().toString() + " 취소", Toast.LENGTH_SHORT).show();
        }
    }
}