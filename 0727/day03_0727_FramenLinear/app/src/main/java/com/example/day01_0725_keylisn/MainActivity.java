package com.example.day01_0725_keylisn;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout LinearM, LinearD, LinearW;
    TextView m;
    EditText edtD, edtW;
    Button btnDok, btnWok, btnM, btnD, btnW;
    int total = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearM = findViewById(R.id.LinearM);
        LinearD = findViewById(R.id.LinearD);
        LinearW = findViewById(R.id.LinearW);
        m = findViewById(R.id.m);
        edtD = findViewById(R.id.edtD);
        edtW = findViewById(R.id.edtW);
        btnDok = findViewById(R.id.btnDok);
        btnWok = findViewById(R.id.btnWok);
        btnM = findViewById(R.id.btnM);
        btnD = findViewById(R.id.btnD);
        btnW = findViewById(R.id.btnW);

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearM.setVisibility(View.VISIBLE);
                LinearW.setVisibility(View.INVISIBLE);
                LinearD.setVisibility(View.INVISIBLE);
                btnM.setBackgroundColor(Color.parseColor("#ffd400"));
                btnD.setBackgroundColor(Color.parseColor("#919191"));
                btnW.setBackgroundColor(Color.parseColor("#919191"));
                m.setText("잔액 " + total);
            }
        });

        btnW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearW.setVisibility(View.VISIBLE);
                LinearM.setVisibility(View.INVISIBLE);
                LinearD.setVisibility(View.INVISIBLE);
                btnW.setBackgroundColor(Color.parseColor("#ffd400"));
                btnD.setBackgroundColor(Color.parseColor("#919191"));
                btnM.setBackgroundColor(Color.parseColor("#919191"));
            }
        });

        btnWok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int money = Integer.parseInt(edtW.getText().toString());
                total -= money;
                m.setText("잔액 " + total);
                Toast.makeText(getApplicationContext(), money + " 원 출금", Toast.LENGTH_SHORT).show();
            }
        });

        btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearD.setVisibility(View.VISIBLE);
                LinearW.setVisibility(View.INVISIBLE);
                LinearM.setVisibility(View.INVISIBLE);
                btnD.setBackgroundColor(Color.parseColor("#ffd400"));
                btnW.setBackgroundColor(Color.parseColor("#919191"));
                btnM.setBackgroundColor(Color.parseColor("#919191"));
            }
        });

        btnDok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int money = Integer.parseInt(edtD.getText().toString());
                total += money;
                m.setText("잔액 " + total);
                Toast.makeText(getApplicationContext(), money + " 원 입금", Toast.LENGTH_SHORT).show();
            }
        });



    }
}