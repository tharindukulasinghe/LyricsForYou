package com.rtlabs.lyricsforyou;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.CustomViewHolder> {

    private List<String> dataList;
    private Context mCtx;

    public GenreAdapter(List<String> dataList,Context context ){

        this.dataList = dataList;
        mCtx = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.genre);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.genre_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        String genre = getItem(position);

        if (genre != null) {

            holder.textView.setText(genre);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mCtx, GenreResultScreen.class);

                    intent.putExtra("genre", genre);
                    mCtx.startActivity(intent);
                }
            });

        } else {
            Toast.makeText(mCtx, "Item is null", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public String getItem(int position) {
        return dataList.get(position);
    }
}