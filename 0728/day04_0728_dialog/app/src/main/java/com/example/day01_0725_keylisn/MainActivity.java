package com.example.day01_0725_keylisn;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtP, edtS;
    Button btnS, btnOk, btnP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtP = findViewById(R.id.edtP);
        edtS = findViewById(R.id.edtS);
        btnS = findViewById(R.id.btnS);
        btnOk = findViewById(R.id.btnOk);
        btnP = findViewById(R.id.btnP);

        registerForContextMenu(btnP);

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                //현재 액티비티 학년 버튼에 팝업 메뉴를 만들 거다!!!
                getMenuInflater().inflate(R.menu.pop, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.pop_m:
                                edtS.setText("남자");
                                return true;
                            case R.id.fm:
                                edtS.setText("여자");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                p.show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = edtP.getText().toString();
                String ss = edtS.getText().toString();
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); //대상
                dlg.setTitle("가입정보 확인");
                dlg.setMessage("전화번호 :" + num + "\n성별 : " + ss);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){
                        Toast.makeText(getApplicationContext(), "확인", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                            // 취소 버튼 클릭시 설정, 왼쪽 버튼입니다.
                            public void onClick(DialogInterface dialog, int whichButton){
                                Toast.makeText(getApplicationContext(), "취소", Toast.LENGTH_SHORT).show();
                            }
                        });
                dlg.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.clear:
                edtS.setText("");
                edtP.setText("");
                return true;
            case R.id.finish:
                finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater minflater = getMenuInflater();
        if (v == btnP) {
            menu.setHeaderTitle("전화번호 선택");
            minflater.inflate(R.menu.number, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.a:
                edtP.setText("010");
                return true;
            case R.id.b:
                edtP.setText("011");
                return true;
            case R.id.c:
                edtP.setText("016");
                return true;
            case R.id.d:
                edtP.setText("017");
                return true;
            case R.id.e:
                edtP.setText("019");
                return true;
            default:
                return false;
        }
    }
}