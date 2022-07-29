package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BankOutput extends Fragment {
        EditText edtout;
        Button btnoutok;

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View v = inflater.inflate(R.layout.bank_output, container, false);
            edtout = v.findViewById(R.id.edtout);
            btnoutok = v.findViewById(R.id.btnoutok);

            btnoutok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int n = Integer.parseInt(edtout.getText().toString());
                    BankData.data -= n;
                    BankData.m.setText("잔액 : " + BankData.data + " 원");
                }
            });

            return v;
        }
    }