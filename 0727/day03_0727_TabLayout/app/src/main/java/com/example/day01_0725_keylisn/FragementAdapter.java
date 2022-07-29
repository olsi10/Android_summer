package com.example.day01_0725_keylisn;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragementAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> frgList = new ArrayList<>(); //extends fragement 전부 묶겠다. 동적삽입 제네릭 구조.
    public FragementAdapter(@NonNull FragmentManager fm) {
        super(fm);
        frgList.add(new BankData());
        frgList.add(new BankInput());
        frgList.add(new BankOutput());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frgList.get(position); //페이지 번호 (개수) 리턴 position은 인덱스 번호
    }

    @Override
    public int getCount() {
        return frgList.size(); //페이지 개수 리턴
    }
}
