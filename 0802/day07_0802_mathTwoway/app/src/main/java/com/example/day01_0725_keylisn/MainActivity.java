package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    RadioGroup rg;
    RadioButton plus, minus, mul, div;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        rg = findViewById(R.id.rg);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Second.class);
                in.putExtra("num1", Integer.parseInt(edt1.getText().toString()));
                in.putExtra("num2", Integer.parseInt(edt2.getText().toString()));

                if(rg.getCheckedRadioButtonId() == R.id.plus) {
                    in.putExtra("op", "+");
                }
                else if(rg.getCheckedRadioButtonId() == R.id.minus) {
                    in.putExtra("op", "-");
                }
                else if(rg.getCheckedRadioButtonId() == R.id.mul) {
                    in.putExtra("op", "*");
                }
                else if(rg.getCheckedRadioButtonId() == R.id.div) {
                    in.putExtra("op", "/");
                }

                startActivityForResult(in, 0);
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int sum = data.getIntExtra("sum", 0); //되돌려 받음
        Toast.makeText(getApplicationContext(), "값 : " + sum, Toast.LENGTH_SHORT).show();

    }
}