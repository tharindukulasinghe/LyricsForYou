package com.rtlabs.lyricsforyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainLyricScreen extends AppCompatActivity {

    Lyric lyric;
    TextView lyrictextview;
    Toolbar toolbar;
    RatingBar ratingbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lyric_screen);

        lyric = (Lyric) getIntent().getSerializableExtra("Lyric");

        lyrictextview = (TextView) findViewById(R.id.lyric);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        toolbar.setTitle(lyric.title);

        lyrictextview.setText(lyric.lyric);

        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        double rating = 0;

        if(lyric.totalratings == 0){
            rating = 0;
        }
        else {
            rating = (lyric.ratingstotal / lyric.totalratings);
        }
        ratingbar.setRating((float)rating);
        addListenerOnButtonClick();
        updateTrending();
    }


    public void addListenerOnButtonClick(){
        ratingbar=(RatingBar)findViewById(R.id.ratingBar);
        button=(Button)findViewById(R.id.button);
        //Performing action on Button Click
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                //Getting the rating and displaying it on the toast
                String rating=String.valueOf(ratingbar.getRating());

                Toast.makeText(getApplicationContext(),"Rating updated!",Toast.LENGTH_LONG);
                rateLyric(rating);


            }

        });
    }

    private void rateLyric(String rate){
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        retrofitClient.getApi().rateLyric(rate,lyric._id).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

                if(response.body() != null){

                }


            }
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
            }
        });
    }

    private void updateTrending(){
        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        retrofitClient.getApi().updateTrending(lyric._id).enqueue(new Callback<SearchResult>() {
            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {

                if(response.body() != null){

                }


            }
            @Override
            public void onFailure(Call<SearchResult> call, Throwable t) {
            }
        });
    }
}
