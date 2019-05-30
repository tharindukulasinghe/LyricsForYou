package com.rtlabs.lyricsforyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitLyricScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_lyric_screen);

    }

    public void submit(View view) {

        EditText artistTextBox   = (EditText)findViewById(R.id.artist);
        EditText titleTextBox   = (EditText)findViewById(R.id.title);
        EditText genreTextBox   = (EditText)findViewById(R.id.genre);
        EditText lyricTextBox   = (EditText)findViewById(R.id.lyric);

        String artist = artistTextBox.getText().toString();
        String title = titleTextBox.getText().toString();
        String genre = genreTextBox.getText().toString();
        String lyric = lyricTextBox.getText().toString();

        RetrofitClient retrofitClient = RetrofitClient.getInstance();

        retrofitClient.getApi().newLyric(artist,genre,lyric,title).enqueue(new Callback<LyricSubmitResult>() {
            @Override
            public void onResponse(Call<LyricSubmitResult> call, Response<LyricSubmitResult> response) {
                Toast.makeText(getApplication(),"Successfully updated.", Toast.LENGTH_LONG);
                if(response.body() != null){
                    if(!response.body().error){
                        Intent intent = new Intent(getApplication(), MainActivity.class);
                        getApplication().startActivity(intent);
                    }
                }
            }
            @Override
            public void onFailure(Call<LyricSubmitResult> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Successfully updated.", Toast.LENGTH_LONG);
                Log.e("length",t.getMessage());
            }
        });

    }

    private void submitLyric(){

    }
}
