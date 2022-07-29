package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox [] chkList = new CheckBox[3];
    Integer [] chkText = {R.id.and, R.id.win, R.id.iphone};
    RadioButton rg;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i < chkList.length; i++) {
            chkList[i] = findViewById(chkText[i]);
        }

        result = findViewById(R.id.result);


//        for(int i = 0; i < chkList.length; i++) {
//            final  int k = i;
//            int finalI = i;
//            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    if (b) {
//                        Toast.makeText(getApplicationContext(), chkList[finalI].getText().toString() + " 선택", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getApplicationContext(), chkList[finalI].getText().toString() + " 취소", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            });
//        }

        for(int i = 0 ; i < chkList.length; i++) {
            final int k = i;
            chkList[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    String s = "";
                    if (b) {
                        s += chkList[k].getText().toString();
                    }
                    result.setText(s);
                }

            });
        }



    }
}