package com.rtlabs.lyricsforyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GenreScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GenreAdapter myAdapter;

    String[] genre = {"Folk,World, Country", "Electronic", "Classical", "Children", "Blues"};

    ArrayList<String> genres = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_screen);

        genres.add("Fork, World, Country");
        genres.add("electronic");
        genres.add("classical");
        genres.add("children");
        genres.add("blues");

        loadDataList();
    }

    private void loadDataList() {

        recyclerView = findViewById(R.id.my_recycler_view);
        myAdapter = new GenreAdapter(genres, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(GenreScreen.this);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(myAdapter);
    }
}
