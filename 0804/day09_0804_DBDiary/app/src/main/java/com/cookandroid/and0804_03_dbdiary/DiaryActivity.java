package com.cookandroid.and0804_03_dbdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.badge.ExperimentalBadgeUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;

public class DiaryActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite, btnDel;
    String fileName;
//    String strSDPath;
//    File myDir;
    ListView diaryList;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    int year; // = cal.get(Calendar.YEAR); //시스템 달력에서 년도 가져ㅏ오기
    int month; // = cal.get(Calendar.MONTH); //시스템 달력에서 월 가져오기
    int day; // = cal.get(Calendar.DAY_OF_MONTH); //시스템 달력에서 일 가져오기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);
        setTitle("[일기장-내장메모리에 저장]");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        dp = findViewById(R.id.dp);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
        btnDel = findViewById(R.id.btnDel);
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR); //시스템 달력에서 년도 가져ㅏ오기
        month = cal.get(Calendar.MONTH); //시스템 달력에서 월 가져오기
        day = cal.get(Calendar.DAY_OF_MONTH); //시스템 달력에서 일 가져오기

        Intent in = getIntent();
        String fname = in.getStringExtra("fname"); //2022_08_05 -> "2022","08", "05"
        String[] arr = fname.split("_"); //언더바로 문자열 분리 -> 문자배열 처리

        year = Integer.parseInt(arr[0]); //2022
        month = Integer.parseInt(arr[1]) - 1; //08 자바에서 월은 0부터 시작
        day = Integer.parseInt(arr[2]); //05

        myHelper = new MyDBHelper(this);

        fileName = Integer.toString(year) + "_" + Integer.toString(month + 1) + "_" + Integer.toString(day);
        String str = readDiary(fileName);
        edtDiary.setText(str);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                fileName = y + "_" + (m+1) + "_" + d; //파일이름 만들기 년_월_일.txt
                String str = readDiary(fileName); //일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnWrite.getText().toString().equals("새로 저장")) { //insert 처리
                    sqlDB = myHelper.getWritableDatabase(); //수정 모드
                    sqlDB.execSQL("INSERT INTO DiaryTBL(diaryDate, content) " + " VALUES( '" + fileName + "', '" +edtDiary.getText().toString() + "');");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
                    btnWrite.setText("수정하기"); btnDel.setVisibility(View.VISIBLE);
                } else { //update 처리 수정 버튼에서 클릭한 경우
                    sqlDB = myHelper.getWritableDatabase(); //수정 모드
                    sqlDB.execSQL("UPDATE DiaryTBL SET content = '" + edtDiary.getText().toString() + "' WHERE diaryDate = '" + fileName + "';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "수정됨", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    sqlDB = myHelper.getWritableDatabase(); //선택한 날짜 삭제
                    sqlDB.execSQL("delete from DiaryTBL where '" + fileName + "';");
                    sqlDB.close();
                    Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();
                    edtDiary.setText("");
                    btnWrite.setText("새로 저장"); btnDel.setVisibility(View.GONE);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "삭제 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    String readDiary(String fname){
        String diaryStr = null;

        sqlDB = myHelper.getReadableDatabase(); //읽기 모드
        Cursor c; //diaryDate = fname = "2022_08_05"
        c = sqlDB.rawQuery("SELECT * FROM DiaryTBL WHERE diaryDate = '"+fname+"';", null);

        if(c.moveToFirst() == true) { //날짜에 일기가 존재하면
            diaryStr = c.getString(2); //content 내요ㅕㅇ 가져오기
            btnWrite.setText("수정하기");
            btnDel.setVisibility(View.VISIBLE);
        } else{
            btnDel.setVisibility(View.GONE); // 삭제 버튼 없애기
            btnWrite.setText("새로 저장");
        }

        c.close(); sqlDB.close();


        return diaryStr;
    }
}