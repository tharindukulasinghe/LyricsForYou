package com.rtlabs.lyricsforyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView card_view = (CardView) findViewById(R.id.artist); // creating a CardView and assigning a value.

        CardView search_card = (CardView) findViewById(R.id.search);

        CardView trending_card = (CardView) findViewById(R.id.trending);

        CardView genre_card = (CardView) findViewById(R.id.genres);

        CardView submit_card = (CardView) findViewById(R.id.submit);

        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Artists.class);
                ItemDataSource.phrase = null;
                startActivity(intent);
            }
        });

        search_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Search.class);
                startActivity(intent);
            }
        });

        trending_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrendingScreen.class);
                startActivity(intent);
            }
        });

        genre_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GenreScreen.class);
                startActivity(intent);
            }
        });

        submit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SubmitLyricScreen.class);
                startActivity(intent);
            }
        });
    }
}
