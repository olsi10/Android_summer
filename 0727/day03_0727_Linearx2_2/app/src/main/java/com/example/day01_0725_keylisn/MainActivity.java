package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinOp;
    Button btn;
    EditText edtX, edtY;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinOp = findViewById(R.id.spinOp);
        btn = findViewById(R.id.btn);
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        result = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = spinOp.getSelectedItemPosition();
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());

                switch (i) {
                    case 0: result.setText("" + (x + y)); break;
                    case 1: result.setText("" + (x - y)); break;
                    case 2: result.setText("" + (x * y)); break;
                    case 3: result.setText("" + (x % y)); break;
                }

//                if(spin == 0) { // +
//                    result.setText(x + y);
//                }
//                else if(spin == 1) {
//                    result.setText(x - y);
//                }
//                else if(spin == 2) {
//                    result.setText(x * y);
//                }
//                else if(spin == 3) {
//                    result.setText(x % y);
//                }
            }
        });

    }
}