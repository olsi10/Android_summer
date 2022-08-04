package com.example.day01_0725_keylisn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context, "infoDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String str = "CREATE TABLE infoTBL(_id integer PRIMARY KEY autoincrement, name char(20), num integer)"; // CursorAdapter 를 사용할 경우 테이블에는 _id 필드를 꼭 써야함
        sqLiteDatabase.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS infoTBL"); //만약 그룹 테이블이 존재하면 삭제하라는 것
        onCreate(sqLiteDatabase);
    }
}
