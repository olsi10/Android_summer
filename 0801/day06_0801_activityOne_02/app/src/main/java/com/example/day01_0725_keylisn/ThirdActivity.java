package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        txt.setText(str);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        });
    }
}