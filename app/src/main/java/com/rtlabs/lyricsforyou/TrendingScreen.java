package com.rtlabs.lyricsforyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendingScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrendingAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_screen);
        getTrending();
    }

    private void getTrending(){
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        retrofitClient.getApi().getTrending().enqueue(new Callback<TrendingResult>() {
            @Override
            public void onResponse(Call<TrendingResult> call, Response<TrendingResult> response) {
                Log.e("length",response.body().results.size()+"");
                if(response.body() != null){
                    loadDataList(response.body());
                }
            }
            @Override
            public void onFailure(Call<TrendingResult> call, Throwable t) {
                Log.e("length",t.getMessage());
            }
        });
    }


    private void loadDataList(TrendingResult usersList) {

        recyclerView = findViewById(R.id.my_recycler_view);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),1);
        recyclerView.addItemDecoration(dividerItemDecoration);
        myAdapter = new TrendingAdapter(usersList.results, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TrendingScreen.this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(myAdapter);
    }
}
