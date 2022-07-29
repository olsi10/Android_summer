package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnContextMenu, btnOptionMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("전체 메뉴 실습");

        btnContextMenu = findViewById(R.id.btnContextMenu);
        btnOptionMenu = findViewById(R.id.btnOptionMenu);

        //컨텍스트 메뉴로 사용되는 위젯은 반드시 등록(레지스터) 하기 >> 롱클릭
        registerForContextMenu(btnContextMenu);

        btnOptionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                //현재 액티비티 학년 버튼에 팝업 메뉴를 만들 거다!!!
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());
                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.pop_1:
                                Toast.makeText(getApplicationContext(), "1학년", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.pop_2:
                                Toast.makeText(getApplicationContext(), "2학년", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.pop_3:
                                Toast.makeText(getApplicationContext(), "3학년", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(), "선택 X", Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                //팝업 메뉴 클릭했을 때 보이기
                p.show();
            }
        });
    }
    //옵션 메뉴, 컨텍스트 생성 item 선택 처리


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.optMenu_loni:
                Toast.makeText(getApplicationContext(), "로그인 선택", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.optMenu_logout:
                Toast.makeText(getApplicationContext(), "로그아웃 선택", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택 X", Toast.LENGTH_SHORT).show();
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v == btnContextMenu) {
            menu.setHeaderTitle("성별 선택");
            menuInflater.inflate(R.menu.menu_context, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.contextMenu_m:
                Toast.makeText(getApplicationContext(), "남자 선택", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextMenu_fm:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); //대상
                dlg.setTitle("성별 선택 확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("여성 선택");
                dlg.setPositiveButton("확인", null);
                dlg.show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택 X", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}