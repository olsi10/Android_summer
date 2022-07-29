package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView num, quiz, pass;
    Button ok, start, next;
    EditText edt;

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

        //
        HashMap[] problems = {
                new HashMap() {
                    {
                        put("캐나다의 수도는?");
                        put("answer", "3");
                        put("example1", "1");
                        put("example2", "3");
                        put("example3", "2");
                        put("example4", "4");
                    }
                },
                new HashMap() {
                    {
                        put("question", "3 + 2 = ?");
                        put("answer", "5");
                        put("example1", "4");
                        put("example2", "6");
                        put("example3", "5");
                        put("example4", "2");
                    }
                },
    }

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
            case R.id.exit:
                finish();
                return true;
            case R.id.restart:
                Toast.makeText(getApplicationContext(), "다시 시작하는 것", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.score:

                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택 X", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}