package com.example.day01_0725_keylisn;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    Button btnInnerWrite, btnInnerRead, btnRawRead;
    EditText edtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 파일 입출력");

        btnInnerRead = findViewById(R.id.btnInnerRead);
        btnInnerWrite = findViewById(R.id.btnInnerWrite);
        btnRawRead = findViewById(R.id.btnRawRead);
        edtData = findViewById(R.id.edtData);

        btnInnerWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput("fileTest.txt", Context.MODE_PRIVATE); //파일 쓰기용도
                    //파일 쓰기용으로 오픈
                    String str = "안녕 오늘 안드로이드 수업 재밋엉";
                    //String str2 = edtData.getText().toString();
                    outFs.write(str.getBytes()); //str의 바이트수만큼 받기
                    outFs.close();
                    Toast.makeText(getApplicationContext(), "fileTest 파일 생성됨", Toast.LENGTH_SHORT).show();

                }catch(Exception e) {

                }
            }
        });

        btnInnerRead.setOnClickListener(new View.OnClickListener() { //리드는 없으면 못 읽음
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = openFileInput("fileTest.txt");
                    byte[] str = new byte[100];
                    inFs.read(str); //바이트로 read, write를 하기 때문에 string으로 형변환 해야 함
                    edtData.setText(new String(str)); //new 형변환
                    inFs.close();

                }catch(Exception e) {
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRawRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inS = getResources().openRawResource(R.raw.test);
                    byte [] in = new byte[inS.available()]; //사이즈만큼 읽음 (글 제한이 없을 때 사용)
                    inS.read(in);
                    String data = new String(in);
                    edtData.setText(data);
                    inS.close();

                }catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}