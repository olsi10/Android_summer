package com.example.day01_0725_keylisn;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CarAdapter extends BaseAdapter {
    Context txt; //메인 엑티비티 저장할 컨텍스트 저장변수, 연결
    Car[] data;
    //생성자


    public CarAdapter(Context txt, Car[] data) {
        this.txt = txt;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.length; //배열 원소 개수
    }

    @Override
    public Object getItem(int i) {
        return data[i]; //해당 아이템을 리턴
    }

    @Override
    public long getItemId(int i) {
        return i; //i >> 인덱스
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) { //초기화
            view = View.inflate(txt, R.layout.listitem, null);
        }
        Car tc = data[i];
        ImageView cimg = (ImageView) view.findViewById(R.id.img);
        TextView title = (TextView) view.findViewById(R.id.title);
        cimg.setImageResource(tc.getImage_id()); //해당하는 i의 값을 이미지로 세팅
        title.setText(tc.getTitle()); //해당하는 i의 값을 제목으로 세팅

        return view;
    }
}
