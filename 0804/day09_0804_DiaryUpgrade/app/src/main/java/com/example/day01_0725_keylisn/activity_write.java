package com.example.day01_0725_keylisn;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class activity_write extends AppCompatActivity {

    Button del;
    DatePicker dp;
    EditText edt;
    String fileName;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        del = findViewById(R.id.del);
        dp = findViewById(R.id.dp);
        edt = findViewById(R.id.edt);

        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        myHelper = new MyDBHelper(this); //초기화
        sqlDB = myHelper.getWritableDatabase(); //읽기 모드
        myHelper.onUpgrade(sqlDB, 1, 2);
        sqlDB.close();

        fileName = Integer.toString(year) + "_" + Integer.toString(month + 1) + "_" + Integer.toString(day);
        String str = readDiary(fileName);
        edt.setText(str);

        dp.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                fileName = Integer.toString(i) + "_" + Integer.toString(i1) + "_" + Integer.toString(i2);
                String str = readDiary(fileName);
                edt.setText(str);
            }
        });

    }

    String readDiary(String fName) {
        String str = null;
        sqlDB = myHelper.getReadableDatabase();
        Cursor c;
        c = sqlDB.rawQuery("SELECT * FROM listTBL WHERE diaryDate = '"+fName+"';", null);
        if(c == null) {
            edt.setHint("일기 없음");
        }
        else {
            if(c.moveToFirst() == true) {
                str = c.getString(1);
            }
            else {
                edt.setHint("일기 없음");
            }
        }
        c.close();
        sqlDB.close();
        return str;
    }
}