package com.rtlabs.lyricsforyou;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
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

public class SearchAdapter extends PagedListAdapter<Lyric, SearchAdapter.ItemViewHolder> {

    private Context mCtx;

    protected SearchAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Lyric item = getItem(position);

        if (item != null) {

            holder.textView.setText(item.title);

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

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
        }
    }
}
