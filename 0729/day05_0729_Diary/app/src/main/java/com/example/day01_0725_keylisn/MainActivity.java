package com.example.day01_0725_keylisn;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText edt;
    DatePicker dp;
    String fileName; //저장할 파일 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시크릿 ★ 다이어리");

        dp = findViewById(R.id.dp);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);
        Calendar cal = Calendar.getInstance(); //캘린더의 레퍼런스를 얻어옴
        int year = cal.get(Calendar.YEAR); //시스템 달력에서 년도 가져옴
        int month = cal.get(Calendar.MONTH); //시스템 달력에서 월 가져옴 (인덱스)
        int day = cal.get(Calendar.DATE); //시스템 달력에서 일 가져옴

        fileName = year + "_" + (month + 1) + "_" + day + ".txt"; //파일이름 만들기 년 월 일.txt
        //오늘 날짜의 일기가 있다면 읽어서 edt(일기 쓰는 곳)에 setText() 하기

        String str = readDiary(fileName); //일기 읽기 완성
        edt.setText(str); //일기 쓴 거 대입

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream ouFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edt.getText().toString();
                    ouFs.write(str.getBytes());
                    ouFs.close();

                    Toast.makeText(getApplicationContext(), "파일 저장됨", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                fileName = i + "_" + (i1 + 1) + "_" + i2 + ".txt";
                String str = readDiary(fileName); //일기 있으면 읽어오기 (날짜 바뀌었을 때)ㅏㄲㄲㄱ
                edt.setText(str);
            }
        });

    }

    //읽는 부분은 따로 메소드로 만들기
    String readDiary(String fname) {
        String data = null; //일기 내용 저장하는 변수

        try {
            FileInputStream inFs = openFileInput("fileTest.txt");
            byte[] in = new byte[500]; //500자 제한
            inFs.read(in);
            data = (new String(in)).trim(); //대입 + 공백 제거거
            btn.setText("수정하기");

           inFs.close();

        }catch(Exception e) {
            Toast.makeText(getApplicationContext(), "없음", Toast.LENGTH_SHORT).show();
        }

        return data;
    }
}