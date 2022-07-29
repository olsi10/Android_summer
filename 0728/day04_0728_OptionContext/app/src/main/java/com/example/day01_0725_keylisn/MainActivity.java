package com.example.day01_0725_keylisn;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView name, num;
    Button fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        num = findViewById(R.id.num);
        fin = findViewById(R.id.fin);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater min = getMenuInflater();
        min.inflate(R.menu.option, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    super.onOptionsItemSelected(item);
    switch (item.getItemId()) {
        case R.id.accept:
         Dialog d;
          d = new Dialog(MainActivity.this);
         d.setContentView(R.layout.dlg);
            d.show();
             return true;
         case R.id.colorChange:
                case R.id.blue:
                    name.setTextColor(Color.BLUE);
                    num.setTextColor(Color.BLUE);
                    return true;
                case R.id.green:
                    name.setTextColor(Color.GREEN);
                    num.setTextColor(Color.BLUE);
                    return true;
                case R.id.basic:
                    name.setTextColor(Color.GRAY);
                    num.setTextColor(Color.BLUE);
                    return true;
            default:
                return false;
            }
}
}
