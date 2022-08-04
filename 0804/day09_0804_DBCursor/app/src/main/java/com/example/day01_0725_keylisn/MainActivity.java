package com.example.day01_0725_keylisn;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtNum;
    Button input, interval, clear;
    ListView list;
    IdolAdapter adapter;
    MyDBHelper myHelper = new MyDBHelper(this);
    SQLiteDatabase sqlDB;

    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        list = findViewById(R.id.list);
        input = findViewById(R.id.input);
        interval = findViewById(R.id.interval);
        clear = findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //테이블 DB에 삭제 후 다시 생성하는 것
                sqlDB = myHelper.getWritableDatabase(); //수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2); //숫자는 버전의미로 아무거나 넣기
                sqlDB.close(); //오픈 후 닫기
            }
        });

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase(); //수정 모드
                    String name = edtName.getText().toString().trim();
                    String num = edtNum.getText().toString().trim();
                    if(!name.isEmpty() && !num.isEmpty()) {
                        String sql = "INSERT INTO infoTBL(name, num) VALUES('"+name+"','"+num+"');";
                        sqlDB.execSQL(sql);
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 완료", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtNum.setText("");
                        interval.callOnClick(); //함수 호출
                    }
                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "이름 또는 연락처를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        interval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase(); //읽기 모드
                Cursor c = sqlDB.rawQuery("SELECT * FROM infoTBL", null);

                if(c.getCount() > 0) {
                    adapter = new IdolAdapter(MainActivity.this, c, true);
                    list.setAdapter(adapter);
                }
                else {
                    adapter = null;
                    list.setAdapter(adapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회 성공", Toast.LENGTH_SHORT).show();
            }
        });

    }
}