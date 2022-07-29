package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //EditText edt_abcd;
    EditText point, nowPoint;
    Button btnEven, btnPoint;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        edt_abcd = findViewById(R.id.edt_abcd);
//        edt_abcd.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View view, int i, KeyEvent keyEvent) {
//                if(keyEvent.getAction()== KeyEvent.ACTION_UP){
//                    Toast.makeText(getApplicationContext(), edt_abcd.getText().toString(), Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });

        setTitle("최윤영 실습 5");

        point = findViewById(R.id.point);
        nowPoint = findViewById(R.id.nowPoint);
        btnEven = findViewById(R.id.btnEven);
        btnPoint = findViewById(R.id.btnPoint);
        result = findViewById(R.id.result);

        btnEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(point.getText().toString());
                int np = Integer.parseInt(nowPoint.getText().toString());
                int re = 0;

                for(int i = num; i <= np; i++) {
                    if(i % 2 == 0) {
                        re += i;
                    }
                }
                result.setText("짝수들의 합 : " + re);


            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(point.getText().toString());
                int np = Integer.parseInt(nowPoint.getText().toString());

                if (np < num) {
                    result.setText("가용할 포인터 X");
                }
                else {
                    int r = np - (np % num);
                    result.setText("가용 포인터 : " + r + "원 입니다.");
                }
            }
        });
    }
}