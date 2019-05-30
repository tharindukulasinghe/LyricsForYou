package com.rtlabs.lyricsforyou;

import android.app.Application;
import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class GenreSongsAdapter extends PagedListAdapter<Lyric, GenreSongsAdapter.ItemViewHolder> {

    private Context mCtx;

    protected GenreSongsAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.search_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Lyric item = getItem(position);

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


    private static DiffUtil.ItemCallback<Lyric> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Lyric>() {
                @Override
                public boolean areItemsTheSame(Lyric oldItem, Lyric newItem) {
                    return oldItem.title == newItem.artist;
                }

                @Override
                public boolean areContentsTheSame(Lyric oldItem, Lyric newItem) {
                    return oldItem.equals(newItem);
                }
            };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        TextView textViewArtist;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
            textViewArtist = itemView.findViewById(R.id.textViewArtist);
        }
    }
}
