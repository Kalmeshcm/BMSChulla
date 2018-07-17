package com.example.abc.bms_chulla;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by ABC on 10-07-2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    Context context;
    Cursor cursor;
    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, temperature, time;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.tv_name);
            temperature = itemView.findViewById(R.id.tv_temperature);
            time = itemView.findViewById(R.id.tv_time);


        }
        @Override
        public void onClick(View view)
        {
            int position = getAdapterPosition();
            Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        }

    }
    public RecyclerAdapter(Context context, Cursor cursor) {
        this.context = context;
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater Inflater = LayoutInflater.from(context);
        View view = Inflater.inflate(R.layout.activity_item, null, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        if (!cursor.move(position)) {
            return;
        }

        String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_2));
        String temperature = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_3));
        String time = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_4));

        holder.name.setText(name);
        holder.temperature.setText(temperature);
        holder.time.setText(time);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }


    public void swapCursor(Cursor newcursor) {
        if (cursor != null) {
            cursor.close();
        }
        cursor = newcursor;
        if (newcursor != null) {
            notifyDataSetChanged();
        }



    }
}
