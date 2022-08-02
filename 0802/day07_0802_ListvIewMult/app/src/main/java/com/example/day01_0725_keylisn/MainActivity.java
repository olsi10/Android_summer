package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btnAdd, remove1;
    ListView listV;
    ArrayList<String> data = new ArrayList<>(); //String 동적 객체배열 string 타입으로 배열 만들기

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);
        btnAdd = findViewById(R.id.btnAdd);
        remove1 = findViewById(R.id.remove1);
        listV = findViewById(R.id.listV);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);
        listV.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listV.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(edt.getText().toString());
                adapter.notifyDataSetChanged(); //데이터 추가로 새로고침
                edt.setText("");
            }
        });

        remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray arr = listV.getCheckedItemPositions();
                if(arr.size() != 0) {
                    for(int i = listV.getCount() - 1; i >= 0; i--) {
                        if (arr.get(i)) {
                            data.remove(i);
                            listV.clearChoices();
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }
        });
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "선택 : " + data.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}