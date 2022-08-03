package com.example.day01_0725_keylisn;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView list;
    CarAdapter cada;

    Car c;

    Car [] carr = {new Car(R.drawable.car1, "SM3"), new Car(R.drawable.car2, "QM6")
            , new Car(R.drawable.car3, "Bongo I"), new Car(R.drawable.car4, "스포티지")
            , new Car(R.drawable.car5, "A5")}; //5개
//    Car [] carr ={R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,R.drawable.car5};

    String[] title = {"SM3", "Qm6", "Bongo I", "스포티지", "K5"}; //5개



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최윤영 ");

        list = (ListView)findViewById(R.id.list);
        cada = new CarAdapter(this, carr);
        list.setAdapter(cada);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car item = (Car)list.getItemAtPosition(i);
                String t = item.getTitle();
                customToast(item);

            }
        });
    }

    public void customToast(Car item) {
        View layout = getLayoutInflater().inflate(R.layout.toast, null);
        ImageView img = (ImageView) layout.findViewById(R.id.carImg);
        TextView txt = (TextView) layout.findViewById(R.id.carTxt);
        img.setImageResource(item.getImage_id());
        txt.setText(item.getTitle());
        Toast t = new Toast(getApplicationContext());
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.setView(layout);
        t.show();
    }
}