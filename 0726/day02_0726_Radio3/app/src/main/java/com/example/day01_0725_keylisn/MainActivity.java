package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton boy, lee, est;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        boy = findViewById(R.id.boy);
        lee = findViewById(R.id.lee);
        est = findViewById(R.id.est);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.boy:
                        Toast.makeText(getApplicationContext(), "보이프렌드 선택", Toast.LENGTH_SHORT).show();
                    case R.id.lee:
                        Toast.makeText(getApplicationContext(), "이승철ㅗ 선택", Toast.LENGTH_SHORT).show();
                    case R.id.est:
                        Toast.makeText(getApplicationContext(), "뉴이스트 선택", Toast.LENGTH_SHORT).show();

                }
            }
        });

        }
}