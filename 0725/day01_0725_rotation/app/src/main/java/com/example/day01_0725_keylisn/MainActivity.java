package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnChg, btnHide;
    ImageView img;
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.froyo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnChg = findViewById(R.id.btnChg);
        btnHide = findViewById(R.id.btnHide);
        img = findViewById(R.id.img);



        btnChg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(type == 1) {
                    img.setImageResource(R.drawable.renoir08);
                    type = 2;
                }
                else {
                    img.setImageResource(R.drawable.cat);
                    type = 1;
                }
            }
        });

        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getVisibility() == View.VISIBLE) {
                    img.setVisibility(View.INVISIBLE);
                    btnHide.setText("숨기기");
                }
                else if(img.getVisibility() == View.INVISIBLE) {
                    img.setVisibility(View.VISIBLE);
                    btnHide.setText("보이기");
                }

            }
        });



    }
}