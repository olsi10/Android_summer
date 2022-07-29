package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;

public class MainActivity extends AppCompatActivity {

    Button btnRead, btnMD, btnMDel, btnSysList;
    EditText edtSD;
    String strSDPath; File myDir; // 앱 디렉터리

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE); //SD 카드 쓰기 모드

        btnRead = findViewById(R.id.btnRead);
        btnMD = findViewById(R.id.btnMD);
        btnMDel = findViewById(R.id.btnMDel);
        btnSysList = findViewById(R.id.btnSysList);
        edtSD = findViewById(R.id.edtSD);

        // 핸드폰에 SD 카드에 절대 경로
        strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        myDir = new File(strSDPath + "/myDir"); //앱 이름의 폴더 경로 세팅

        btnMD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!myDir.exists())myDir.mkdir();
            }
        });

        btnMDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inFs = new FileInputStream(strSDPath + "/myDir/test.txt");
                    byte[] in = new byte[inFs.available()]; //500자 제한
                    inFs.read(in);
                    edtSD.setText(new String(in)); //대입 + 공백 제거거

                    inFs.close();

                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "없음", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSysList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //잘 안쓰지만 간단하게 함
                //SD 카드에 있는 목록을 쭉 가져오는 것.
                File[] sysFiles = (new File(strSDPath).listFiles());
                String strFname = "파일 및 폴더 개수 : " + sysFiles.length;
                for(int i = 0 ; i < sysFiles.length; i++) {
                    if(sysFiles[i].isDirectory()) { //폴더인지 아닌지 확인
                        strFname += "\n[폴더] " + sysFiles[i].toString();
                    }
                    if(sysFiles[i].isFile()) { //파일인지 아닌지 확인
                        strFname += "\n[파일] " + sysFiles[i].toString();
                    }
                    edtSD.setText(strFname);
                }
            }
        });
    }
}