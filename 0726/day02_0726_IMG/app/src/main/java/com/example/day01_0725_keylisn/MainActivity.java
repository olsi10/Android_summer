package com.example.day01_0725_keylisn;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    RadioGroup rg;
    RadioButton nuga, oreo;
    ImageView nu;
    Button showTxt, go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영");

        getSupportActionBar().setIcon(R.mipmap.ic_launcher_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edt = findViewById(R.id.edt);
        rg = findViewById(R.id.rg);
        nuga = findViewById(R.id.nuga);
        oreo = findViewById(R.id.oreo);
        nu = findViewById(R.id.nu);
        showTxt = findViewById(R.id.showTxt);
        go = findViewById(R.id.go);

        showTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str  = edt.getText().toString();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edt.getText().toString();
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(urlOpen);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkID) {
                if(checkID == R.id.nuga) {
                    nu.setImageResource(R.drawable.nougat);
                }
                else if(checkID == R.id.oreo) {
                    nu.setImageResource(R.drawable.oreo);
                }
            }
        });

    }
}