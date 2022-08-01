package com.example.day01_0725_keylisn;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    TextView num, quiz, pass;
    Button ok, start, next;
    EditText edt;
    int index = 0; //문제번호
    int ans_num = 0; //맞은 개수

    String[] q = {"내 생일은 (생년월일 8자로 작성)?", "내가 사는 곳은 (00시)?", "신발 사이즈는??", "학번은?", "내가 매일 들고 다니는 것 ㅋㅋ?"};
    String[] ans = {"20050304", "a", "235", "2311", "bottle"};

    File myDir;              //생성할 디렉터리 변수
    String strSDpath;       //SD카드 절대주소

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        num = findViewById(R.id.num);
        quiz = findViewById(R.id.quiz);
        pass = findViewById(R.id.pass);
        ok = findViewById(R.id.ok);
        start = findViewById(R.id.start);
        next = findViewById(R.id.next);
        edt = findViewById(R.id.edt);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath(); //절대 경로
        strSDpath += "/myQuiz/";
        myDir = new File(strSDpath);
        if (!myDir.isDirectory()) myDir.mkdir(); //디렉토리 없으면 생성

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index = 0;
                ans_num = 0;
                num.setText("문제 - " + (index + 1));
                quiz.setText(q[index]);
                ok.setEnabled(true);
                start.setEnabled(false);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edt.setText("");
                next.setEnabled(false);
                index++;
                if (index < ans.length) {
                    pass.setText("OX");
                    num.setText("문제 - " + (index + 1));
                    quiz.setText(q[index]);
                    edt.setText("");
                } else {
                    pass.setText("OX");
                    num.setText("문제 - Number");
                    quiz.setText("문제");
                    ok.setEnabled(false);
                    start.setEnabled(false);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle("퀴즈 맞은 개수");
                    dlg.setMessage("총 맞은 개수 : " + ans_num + "\n점수 저장할 것?");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            View dlgViewInput = (View) View.inflate(MainActivity.this, R.layout.dlg, null);
                            AlertDialog.Builder dlgin = new AlertDialog.Builder(MainActivity.this);
                            dlgin.setTitle("파일 이름 입력 : 이름과 아이디 입력");
                            dlgin.setView(dlgViewInput); //다이얼로그에서 일므과 아이디를 입력받아 파일이름으로 저장
                            dlgin.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    EditText edtName = (EditText) dlgViewInput.findViewById(R.id.edtName);
                                    EditText edtID = (EditText) dlgViewInput.findViewById(R.id.edtID);
                                    String name = edtName.getText().toString();
                                    String ID = edtID.getText().toString();
                                    String fileName = strSDpath + name + "_" + ID + ".txt";
                                    try {
                                        FileOutputStream outFs = new FileOutputStream(fileName);
                                        String str = "총 5문제에서 맞은 개수 " + ans_num;
                                        outFs.write(str.getBytes()); //sd카드에 저장
                                        outFs.close();

                                        Toast.makeText(getApplicationContext(), strSDpath + fileName + "에 점수 저장", Toast.LENGTH_SHORT).show();
                                    } catch (FileNotFoundException e) {
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            dlg.setNegativeButton("취소", null);
                            dlg.show();
                        }
                    });
                    dlg.setNegativeButton("취소", null);
                    dlg.show();
                }
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edt.getText().toString();
                if (s.equals("")) {
                    Toast.makeText(getApplicationContext(), "답 먼저 적어라 빙봉아", Toast.LENGTH_SHORT).show();
                } else {
                    if (s.equals(ans[index])) {
                        ans_num++;
                        pass.setText("O : 맞았으");
                        next.setEnabled(true);
                    } else {
                        pass.setText("X : 틀렸으");
                        next.setEnabled(true);
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater min = getMenuInflater();
        min.inflate(R.menu.option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        AlertDialog.Builder dlg;
        switch (item.getItemId()) {
            case R.id.exit:
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("종료");
                dlg.setMessage("프로그램 종료");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();

                return true;
            case R.id.next:
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("다시 풀기");
                dlg.setMessage("처음부터 다시 풀기");
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        index = 0;
                        num.setText("문제 - " + (index + 1));
                        quiz.setText(q[index]);
                        ok.setEnabled(true);
                        start.setEnabled(false);
                        next.setEnabled(false);
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();

                return true;

            case R.id.score:
                View dlgViewScore = (View) View.inflate(MainActivity.this, R.layout.dlg, null);
                dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("파일 이름 입력 : 이름과 아이디 입력");
                dlg.setView(dlgViewScore);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText edtName = (EditText) dlgViewScore.findViewById(R.id.edtName);
                        EditText edtID = (EditText) dlgViewScore.findViewById(R.id.edtID);
                        String name = edtName.getText().toString();
                        String id = edtID.getText().toString();

                        String fileName = strSDpath + name + "_" + id + ".txt";

                        try { //점수확인
                            FileInputStream inFs = new FileInputStream(fileName);
                            byte[] txt = new byte[inFs.available()];
                            inFs.read(txt);
                            String score = new String(txt);
                            inFs.close();
                            Toast.makeText(getApplicationContext(), name + " 님 점수 확인\n" + score, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "파일이 존재하지 않음", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
                return true;
        }
        return true;
    }
}