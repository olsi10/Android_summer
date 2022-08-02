package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 뿡");

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), SecondActivity.class);
                in.putExtra("num1", Integer.parseInt(edt1.getText().toString()));
                in.putExtra("num2", Integer.parseInt(edt2.getText().toString()));
                startActivityForResult(in, 0); //requestCode 는 액티버티 번호
                //세컨 액티비티에 return 값이 있을 때 사용(세컨에서 putExtra) 되돌려받는 경우 사용
            }
        });

    } //onCreate 밑에 onResult() 함수 구현
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int sum = data.getIntExtra("sum", 0); //되돌려 받음
        Toast.makeText(getApplicationContext(), "더한 값 : " + sum, Toast.LENGTH_SHORT).show();
    }
}