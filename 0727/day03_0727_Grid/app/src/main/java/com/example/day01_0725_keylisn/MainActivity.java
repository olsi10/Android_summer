package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton pa1, pa2, pa3;
    ImageView img;
    Button btn;

    int p1 = 0;
    int p2 = 1;
    int p3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영의 개쩌는 가게");

        rg = findViewById(R.id.rg);
        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);
        pa1 = findViewById(R.id.pa1);
        pa2 = findViewById(R.id.pa2);
        pa3 = findViewById(R.id.pa3);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.pa1:
                        img.setImageResource(R.drawable.pasta1);
                        break;
                    case R.id.pa2:
                        img.setImageResource(R.drawable.pasta2);
                        break;
                    case R.id.pa3:
                        img.setImageResource(R.drawable.pasta3);
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pa1.isChecked()) {
                    String p1 = pa1.getText().toString();
                    Toast.makeText(getApplicationContext(), p1 + "주문하셨습니다.", Toast.LENGTH_SHORT).show();
                } else if (pa2.isChecked()) {
                    String p2 = pa2.getText().toString();
                    Toast.makeText(getApplicationContext(), p2 + "주문하셨습니다.", Toast.LENGTH_SHORT).show();
                } else if (pa3.isChecked()) {
                    String p3 = pa3.getText().toString();
                    Toast.makeText(getApplicationContext(), p3 + "주문하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}