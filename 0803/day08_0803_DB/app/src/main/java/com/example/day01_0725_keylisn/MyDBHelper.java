package com.example.day01_0725_keylisn;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context, "groupDB.db", null, 1); //컨텍스트, DB이름, 사용 유무, 버전
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //테이블 생성 / 쿼리 명령어 문자열로 만든 것
        String str = "CREATE TABLE groupTBL(gName char(20) primary key, gNumber integer)"; //보통 대문자 많이 씀
                                                //변수  타입        주키          변수  타입
        sqLiteDatabase.execSQL(str); //실행 명령어
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists groupTBL"); //만약 그룹 테이블이 존재하면 삭제하라는 것
        onCreate(sqLiteDatabase);
    }
}