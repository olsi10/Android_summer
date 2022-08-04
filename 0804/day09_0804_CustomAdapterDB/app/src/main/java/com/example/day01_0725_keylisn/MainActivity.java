package com.example.day01_0725_keylisn;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtNum;
    Button input, interval, clear;
    ListView list;

    MyDBHelper myHelper = new MyDBHelper(this);
    SQLiteDatabase sqlDB;

    ContactAdapter cAdapter;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        input = findViewById(R.id.input);
        interval = findViewById(R.id.interval);
        clear = findViewById(R.id.clear);
        list = findViewById(R.id.list);
        myHelper = new MyDBHelper(this);

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
                    cAdapter = new ContactAdapter(MainActivity.this, c, true);
                    list.setAdapter(cAdapter);
                }
                else {
                    cAdapter = null;
                    list.setAdapter(cAdapter);
                }
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회 성공", Toast.LENGTH_SHORT).show();
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView name = view.findViewById(R.id.edtName);
                TextView num = view.findViewById(R.id.edtNum);
                String out = "이름 : " + name.getText().toString();
                out += "\n전번 : " + num.getText().toString();
                Toast.makeText(getApplicationContext(), out, Toast.LENGTH_SHORT).show();
            }
        });
//
//        clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myHelper = new MyDBHelper(this);
//                sqlDB = myHelper.getWritableDatabase();
//                myHelper.onUpgrade(sqlDB, 1, 2);
//                sqlDB.close();
//            }
//        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        c.close(); //커서 닫으면 오류. onStop 메소드에서 닫아주어야 함
    }
}