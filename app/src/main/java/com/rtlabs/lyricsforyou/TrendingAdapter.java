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

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.CustomViewHolder> {

    private List<Trending> dataList;
    private Context mCtx;

    public TrendingAdapter(List<Trending> dataList,Context context ){

        this.dataList = dataList;
        mCtx = context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textViewArtist;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            textViewArtist = itemView.findViewById(R.id.textViewArtist);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.trending_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        Trending trending = getItem(position);
        Lyric item = trending.lyric;

        if (item != null) {

            holder.textView.setText(item.title);
            holder.textViewArtist.setText(item.artist);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mCtx, MainLyricScreen.class);

                    intent.putExtra("Lyric", item);
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

    public Trending getItem(int position) {
        return dataList.get(position);
    }
}