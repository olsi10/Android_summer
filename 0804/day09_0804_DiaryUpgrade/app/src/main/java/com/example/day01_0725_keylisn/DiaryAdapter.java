package com.example.day01_0725_keylisn;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class DiaryAdapter extends CursorAdapter {
    public DiaryAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.item, null);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtItem = view.findViewById(R.id.item);

        txtItem.setText(cursor.getString(1));
        // txtName.setText(cursor.getString(cursor.getColumnIndex(1));
    }
}
