package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edt;
    Button btn;
    String fileName;//파일이름
    String strSDPath;
    File myDir;//앱 디렉터리 이름

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("[일기장-SD메모리에 저장]");
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        dp = findViewById(R.id.dp);
        edt = findViewById(R.id.edt);
        btn = findViewById(R.id.btn);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//시스템 달력에서 년도 가져오기
        int month = cal.get(Calendar.MONTH);//시스템 달력에서 월(0부터 시작) 가져오기
        int day = cal.get(Calendar.DAY_OF_MONTH);//시스템 달력에서 일 가져오기
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        strSDPath += "/myDiaryApp/";
        myDir = new File(strSDPath);
        if (!myDir.isDirectory()) myDir.mkdir();
        //* 파일이름="SD카드 절대경로/디렉터리/파일명"
        fileName = strSDPath + year + "_" + (month + 1) + "_" + day + ".txt";//파일이름 만들기 "년_월_일.txt"
        //오늘날짜의 일기가 있으면 읽어서 edtDiary에 setText()하기
        String str = readDiary(fileName);//일기 읽기 완성
        edt.setText(str);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = new FileOutputStream(fileName);
                    String str = edt.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + "파일 저장됨",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
            }
        });
        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = strSDPath + y + "_" + (m + 1) + "_" + d + ".txt";
                String str = readDiary(fileName);//일기 있으면 읽어오기
                edt.setText(str);
            }
        });
    }
    //파일 읽기 함수 따로 정의
    String readDiary(String fname) {
        String diaryData = null;//일기 내용 저장하는 변수
        try {
            FileInputStream inFs = new FileInputStream(fname);//년_월_일.txt 파일 읽기
            byte[] in = new byte[500];
            inFs.read(in);
            diaryData = (new String(in)).trim();//양끝에 공백제거함수 trim()
            btn.setText("수정하기");
            inFs.close();
        } catch (Exception e) {
            btn.setText("새로저장");
        }
        return diaryData;
    }
}