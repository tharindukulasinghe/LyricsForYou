package com.rtlabs.lyricsforyou;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class GenreResultScreen extends AppCompatActivity {

    String genre;
    TextView lyrictextview;
    Toolbar toolbar;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_result_screen);

        genre = (String) getIntent().getStringExtra("genre");

        lyrictextview = (TextView) findViewById(R.id.lyric);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        toolbar.setTitle(genre);

        GenreSongsDataSource.genre = genre;

        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);

        GenreSongsViewModel itemViewModel = ViewModelProviders.of(this).get(GenreSongsViewModel.class);

        final GenreSongsAdapter adapter = new GenreSongsAdapter(this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Lyric>>() {
            @Override
            public void onChanged(@Nullable PagedList<Lyric> items) {
                adapter.submitList(items);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
