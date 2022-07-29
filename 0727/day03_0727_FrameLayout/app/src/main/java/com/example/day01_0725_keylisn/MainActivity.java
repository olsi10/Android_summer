package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView img1, img2;
    int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeIMG();
            }
        });
    }

    private void changeIMG() {
        if (type == 1) {
            img1.setVisibility(View.VISIBLE);
            img2.setVisibility(View.INVISIBLE);
            type = 2;
        } else if(type == 2){
            img1.setVisibility(View.INVISIBLE);
            img2.setVisibility(View.VISIBLE);
            type = 1;
        }
    }
}