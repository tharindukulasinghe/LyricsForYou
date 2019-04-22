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
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    SearchView searchView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = (SearchView) findViewById(R.id.search_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Search.this, query, Toast.LENGTH_LONG).show();
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
                recyclerView.addItemDecoration(dividerItemDecoration);
                SearchViewModel.phrase = query;
                SearchViewModel itemViewModel = ViewModelProviders.of(Search.this).get(SearchViewModel.class);
                final SearchAdapter adapter = new SearchAdapter(Search.this);

                itemViewModel.itemPagedList.observe(Search.this, new Observer<PagedList<Lyric>>() {
                    @Override
                    public void onChanged(@Nullable PagedList<Lyric> items) {
                        adapter.submitList(items);
                    }
                });

                recyclerView.setAdapter(adapter);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //    adapter.getFilter().filter(newText);
                return false;
            }
        });
    }



}
