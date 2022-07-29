package com.cookandroid.day01_0725_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtNum;
    EditText edtNum;
    Button btnSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = findViewById(R.id.txtNum);
        edtNum = findViewById(R.id.edtNum);
        btnSum = findViewById(R.id.btnSum);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtNum.getText().toString();
                int num = Integer.parseInt(str);
                int sum = 0;

                for(int i = 1; i <= num; i++) {
                    sum += i;
                }

                Toast.makeText(getApplicationContext(), sum, Toast.LENGTH_SHORT).show();
            }
        });

        edtNum.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_UP){
                    Toast.makeText(getApplicationContext(), edtNum.getText(), Toast.LENGTH_SHORT).show();
                }
                if(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    int n = Integer.parseInt(edtNum.getText().toString());
                    int s = 0;
                    for(int j = 1; j <= n; i++) {
                        String str = "결과 : 1~" + n + "까지의 합" + s;
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    }
                }

                return false;

            }
        });
    }
}