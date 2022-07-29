package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox [] chkList = new CheckBox[4];
    Integer [] chkText = {R.id.str, R.id.mang, R.id.watmel, R.id.kiwi};
 //   CheckBox str, mang, watmel, kiwi;

    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        str = findViewById(R.id.str);
//        mang = findViewById(R.id.mang);
//        watmel = findViewById(R.id.watmel);
//        kiwi = findViewById(R.id.kiwi);

        result = findViewById(R.id.result);
        btn = findViewById(R.id.btn);
//
        for(int i = 0; i < chkList.length; i++) {
            chkList[i] = findViewById(chkText[i]);
        }

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String s = "";
//                if(str.isChecked() == true) {
//                    s += str.getText().toString();
//                }
//                if(mang.isChecked() == true) {
//                    s += mang.getText().toString();
//                }
//                if(watmel.isChecked() == true) {
//                    s += watmel.getText().toString();
//                }
//                if(kiwi.isChecked() == true) {
//                    s += kiwi.getText().toString();
//                }
//
//                result.setText(s);
//            }
//        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                for(int i = 0; i < chkList.length; i++) {
                    if(chkList[i].isChecked() == true) {
                        s += chkList[i].getText().toString();
                    }
                }
                result.setText(s);
            }
        });

        for(int i = 0 ; i < chkList.length; i++) {
            final  int k = i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    btn.performClick();
                }
            });
        }

        }



}