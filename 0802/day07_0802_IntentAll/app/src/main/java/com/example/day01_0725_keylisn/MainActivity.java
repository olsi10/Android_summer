package com.example.day01_0725_keylisn;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button call, open, openMap, search, sendMSG, take, see, sendEMAIL, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call = findViewById(R.id.call);
        open = findViewById(R.id.open);
        openMap = findViewById(R.id.openMap);
        search = findViewById(R.id.search);
        sendMSG = findViewById(R.id.sendMSG);
        take = findViewById(R.id.take);
        see = findViewById(R.id.see);
        sendEMAIL = findViewById(R.id.sendEAMIL);
        back = findViewById(R.id.back);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("tel : 010-4567-5788");
                Intent in = new Intent(Intent.ACTION_DIAL, u);
                startActivity(in);
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://www.e-mirim.hs.kr/main.do");
                Intent in = new Intent(Intent.ACTION_VIEW, u);
                startActivity(in);
            }
        });

        openMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("https://google.map.com");
                Intent in = new Intent(Intent.ACTION_VIEW, u);
                startActivity(in);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("google.com");
                Intent in = new Intent(Intent.ACTION_WEB_SEARCH, u);
                in.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(in);
            }
        });

        sendMSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_SENDTO);
                in.putExtra("sms_body", "안녕하세요");
                in.setData(Uri.parse("smsto" + Uri.encode("010-0303-3030")));
                startActivity(in);
            }
        });

        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(in);
            }
        });

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("content://contacts/people");
                Intent in = new Intent(Intent.ACTION_VIEW, u);
                startActivity(in);
            }
        });

        sendEMAIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri u = Uri.parse("mailto:" + "birchTree@naver.com");
                Intent in = new Intent(Intent.ACTION_SENDTO, u);
                in.putExtra("sms_body", "hello");
                startActivity(in);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    } //onCreate


    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.i("액티비티 테스트", "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.i("액티비티 테스트", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.i("액티비티 테스트", "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        android.util.Log.i("액티비티 테스트", "onReStart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
    }
}