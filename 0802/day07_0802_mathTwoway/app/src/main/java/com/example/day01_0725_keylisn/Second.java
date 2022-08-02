package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Second extends AppCompatActivity {

    Button btn;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn = findViewById(R.id.btn);

        Intent in = getIntent();
        int x = in.getIntExtra("num1", 0);
        int y = in.getIntExtra("num2", 0);

        String op = in.getStringExtra("op");

        switch (op) {
            case "+" : sum = x + y; break;
            case "-" : sum = x - y; break;
            case "*" : sum = x * y; break;
            case "/" : sum = x / y; break;
            default: sum = 0;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("sum", sum);
                setResult(RESULT_OK, out);
                finish();
            }
        });

    }
}