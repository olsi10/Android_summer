package com.example.day01_0725_keylisn;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class IdolAdapter extends CursorAdapter {
    public IdolAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.list, null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtName = view.findViewById(R.id.name);
        TextView txtNum = view.findViewById(R.id.num);

        txtName.setText(cursor.getString(1));
        // txtName.setText(cursor.getString(cursor.getColumnIndex(1));
        txtNum.setText(cursor.getString(2));
    }
}
