package com.example.day01_0725_keylisn;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtCnt;
    Button clear, input, interval;

    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    TextView group, cnt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 연예인 그룹 관리자 돼보기 DB 실습");

        edtName = findViewById(R.id.edtName);
        edtCnt = findViewById(R.id.edtCnt);
        clear = findViewById(R.id.clear);
        input = findViewById(R.id.input);
        interval = findViewById(R.id.interval);
        group = findViewById(R.id.group);
        cnt = findViewById(R.id.cnt);

        myHelper = new MyDBHelper(this); //현재 액티비티의 레퍼런스 >>> context >> this

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
            public void onClick(View view) { //테이블에 데이터 삽입
                try { //반드시 DB도 try catch 구문에 들어가야 함
                    String name = edtName.getText().toString().trim(); //공백 제거
                    int cnt = Integer.parseInt(edtCnt.getText().toString()); //형변환 문자열 -> 정수

                    if(name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "이름 입력 필수", Toast.LENGTH_SHORT).show();
                    }
                    else { //공백이 아니라면 수정모드 오픈하여 입력
                        // String s = "이름" + name + "나이" + num;
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('"+name+"', "+cnt+");"); //SQL문 실행 코드
                        //DB에서 문자열은 작은따옴표!!
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                        edtName.setText(""); edtCnt.setText("");
                        interval.callOnClick(); // 함수 호출
                    }

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        interval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor c = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹 이름\r\n" + "------------------\r\n";
                String strCnt = "인원\r\n" + "-----------------\r\n";

                while (c.moveToNext()) {
                    strNames += c.getString(0) + "\n"; //첫 번째로 가져옴
                    strCnt += c.getInt(1) + "\n"; //두 번째로 가져옴
                }
                group.setText(strNames);
                cnt.setText(strCnt);
                c.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회회 완료", Toast.LENGTH_SHORT).show();
            }
        });

    }
}