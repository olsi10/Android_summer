package com.example.day01_0725_keylisn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tablay;
    ViewPager vp;
    FragementAdapter frgAD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤용 개쩌는 은행");

        tablay = findViewById(R.id.tablay);
        vp = findViewById(R.id.vp);
        frgAD = new FragementAdapter(getSupportFragmentManager());

        tablay.setupWithViewPager(vp);

        vp.setAdapter(frgAD);

        tablay.getTabAt(0).setText("잔액");
        tablay.getTabAt(1).setText("입금");
        tablay.getTabAt(2).setText("출금");
        

    }
}