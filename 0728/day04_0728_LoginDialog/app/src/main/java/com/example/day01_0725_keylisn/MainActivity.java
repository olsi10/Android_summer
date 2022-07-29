package com.example.day01_0725_keylisn;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView edtName, edtNum;
    Button logIn, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        logIn = findViewById(R.id.logIn);
        cancel = findViewById(R.id.cancel);

        registerForContextMenu(cancel);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String num = edtNum.getText().toString();
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this); //대상
                dlg.setTitle("가입정보 확인");
                dlg.setMessage("이름 :" + name + "\n전화번호 : " + num);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int whichButton){
                        Toast.makeText(getApplicationContext(), "확인 누름", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener(){
                    // 취소 버튼 클릭시 설정, 왼쪽 버튼입니다.
                    public void onClick(DialogInterface dialog, int whichButton){
                        Toast.makeText(getApplicationContext(), "안함", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        if(v == cancel) {
            menu.setHeaderTitle("선택");
            menuInflater.inflate(R.menu.context, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.clear:
                edtName.setText("");
                edtNum.setText("");
                return true;
            case R.id.finish:
                finish();
                return true;
            default:
                return false;
        }
    }
}