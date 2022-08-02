package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    MovieAdapter mada;
    ArrayList<Movie> marr;
    Movie m;

    Integer[] poster = {R.drawable.b44916808f2f9fb1819958d44563cac0,
            R.drawable.c00d9708a9207fc3c4973dd1b9582f2d,
            R.drawable.cb4c12ea699256384e1399a0d63dff3b,
            R.drawable.dc3866adca9ab8eeb128ed0170e12cb3,
            R.drawable.fa9bf03247afa8c7462f714d09740007,
            R.drawable.faaf95c03322517925fb0021dc82a0c3}; //6개

    String[] title = {"토이스토리4", "제임스본드" ,"반지의 제왕", "정직한 후보"
            ,"나쁜 녀석들", "겨울왕국"}; //6개

    String[] type = {"액션", "청불", "공포", "드라마", "청불","청불"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 ");

        list = findViewById(R.id.list);
        marr = new ArrayList<Movie>();

        for(int i = 0; i < poster.length; i++) {
            m = new Movie(ContextCompat.getDrawable(this, poster[i]), title[i], type[i]);
            marr.add(m);
        }// 무비 객체 초기화 ArrayList에 값으로 생성

        mada = new MovieAdapter(this, marr);
        list.setAdapter(mada);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie item = (Movie)list.getItemAtPosition(i);
                String t = item.getTitle();
                Toast.makeText(getApplicationContext(), "선택 :" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}