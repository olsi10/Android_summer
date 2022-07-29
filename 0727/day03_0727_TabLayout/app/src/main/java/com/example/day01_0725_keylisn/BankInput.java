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

public class BankInput extends Fragment {
    EditText edtin;
    Button btninOk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.bank_intput, container, false);
        edtin = v.findViewById(R.id.edtin);
        btninOk = v.findViewById(R.id.btninok);

        btninOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(edtin.getText().toString());
                BankData.data += n;
                BankData.m.setText("잔액 : " + BankData.data + " 원");
            }
        });

        return v;
    }
}
