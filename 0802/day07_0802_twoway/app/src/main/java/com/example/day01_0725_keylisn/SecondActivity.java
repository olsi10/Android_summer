package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        back = findViewById(R.id.back);

        Intent in = getIntent();
        int x = in.getIntExtra("num1", 0);
        int y = in.getIntExtra("num2", 0);
        final int sum = x + y;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("sum", sum);
                setResult(RESULT_OK, out); //기존에 나를 호출한 곳에 되돌려 주는 것 setResult
                finish(); //닫아줘야 메인액티비티에서 보임

            }
        });
    }
}