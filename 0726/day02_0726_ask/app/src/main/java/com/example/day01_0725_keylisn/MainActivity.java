package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    CheckBox chkStart;
    RadioGroup rg;
    RadioButton ko, jp, en, bbong;
    ImageView img;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkStart = findViewById(R.id.chkStart);
        rg = findViewById(R.id.rg);
        ko = findViewById(R.id.ko);
        jp = findViewById(R.id.jp);
        en = findViewById(R.id.en);
        bbong = findViewById(R.id.bbong);
        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txt);

        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkStart.isChecked()) {
                    txt.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                }
                else {
                    txt.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    btn.setVisibility(View.INVISIBLE);
                }
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.ko:
                        img.setImageResource(R.drawable.an);
                        break;
                    case R.id.jp:
                        img.setImageResource(R.drawable.fox2);
                        break;
                    case R.id.en:
                        img.setImageResource(R.drawable.yun);
                        break;
                    case R.id.bbong:
                        img.setImageResource(R.drawable.renoir08);
                        break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                img.setImageDrawable(null);
            }
        });





    }
}