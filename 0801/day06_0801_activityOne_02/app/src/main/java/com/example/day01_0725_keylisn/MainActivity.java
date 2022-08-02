package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb2, rb3;
    Button btn;
    EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        btn = findViewById(R.id.btn);
        edt = findViewById(R.id.edt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edt.getText().toString(); //값 가져오기
                if(rg.getCheckedRadioButtonId() == R.id.rb2) {
                    Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                    in.putExtra("Content", str); //content는 변수이름, str은 값
                    startActivity(in);
                }
                else {
                    Intent in = new Intent(getApplicationContext(), ThirdActivity.class);
                    in.putExtra("Content", str); //content는 변수이름, str은 값
                    startActivity(in);
                }
            }
        });

    }
}