package com.rtlabs.lyricsforyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class MainLyricScreen extends AppCompatActivity {

    Lyric lyric;
    TextView lyrictextview;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lyric_screen);

        lyric = (Lyric) getIntent().getSerializableExtra("Lyric");

        lyrictextview = (TextView) findViewById(R.id.lyric);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);

        toolbar.setTitle(lyric.title);

        lyrictextview.setText(lyric.lyric);
    }
}
