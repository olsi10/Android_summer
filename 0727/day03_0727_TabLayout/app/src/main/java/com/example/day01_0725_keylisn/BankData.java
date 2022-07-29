package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankData extends Fragment {
    public static TextView m;
    public static int data = 10000; //통장 잔액

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.bank_data, container, false); //bank_data로 연결하겠다.
        m = v.findViewById(R.id.m); //bank_data에 있는 m을 갖고 오겠다.
        m.setText("잔액 : " + BankData.data + " 원"); //스태틱에 붙은 거는 클래스 이름으로 다이렉트로 접근 가능

        return m; //클래스의 타입이 View 이기 때문에 리턴값도 View 타입의 m을 리턴턴
    }
}

