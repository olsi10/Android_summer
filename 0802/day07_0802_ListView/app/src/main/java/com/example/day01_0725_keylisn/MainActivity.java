package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    Button btn;
    ArrayList<String> choice = new ArrayList<>(); //String 동적 객체배열 string 타입으로 배열 만들기


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        btn = findViewById(R.id.btn);

        final String[] data = {"히어로즈", "24시", "로스트", "로스트룸", "스몰빌", "탐정몽크",
                "빅뱅이론", "프렌즈", "덱스터", "글리", "가쉽걸", "테이큰", "슈퍼내추럴", "브이"};

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //한 개 할 거면 SINGLE (라디오 버튼), 여러 개 할 거면 MULTIPLE (체크박스)
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), data[i] + "선택", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choice.clear();
                SparseBooleanArray chkItem = list.getCheckedItemPositions(); //true,false 값을 받는 배열 (체크 유무값)
                if(chkItem.size() != 0) { //선택된 크기 = size
                    for(int i = 0; i < data.length; i++) {
                        if(chkItem.get(i)) {
                            choice.add(data[i]);
                        }
                    }
                    String str = "";
                    for(String s : choice) {
                        str += s + " ";
                    }
                    Toast.makeText(getApplicationContext(), "선택" + str, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}