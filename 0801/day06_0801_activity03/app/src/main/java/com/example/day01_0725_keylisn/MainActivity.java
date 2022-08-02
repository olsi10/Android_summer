package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton male, female;
    Button btn;
    EditText edtName, edtNum, edtAdr;

    String name;
    String address;
    String gender;
    int num = 0;

    ArrayList<String> s = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        btn = findViewById(R.id.btn);
        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        edtAdr = findViewById(R.id.edtAdr);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtName.getText().toString();
                try {
                    num = Integer.parseInt(edtNum.getText().toString());
                }
                catch (Exception e) {}
                if(rg.getCheckedRadioButtonId() == R.id.male) gender = "남자";
                else gender ="여자";
                Intent in = new Intent(getApplicationContext(), Result.class);

               startActivity(in);
            }
        });

    }
}