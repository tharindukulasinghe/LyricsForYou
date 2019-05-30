package com.rtlabs.lyricsforyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("LyricsForYou is a product of Oqtave Labs that enables users to search lyrics for phrases and also submit lyrics for their favorite songs. It also enables users to search lyrics of songs of their favorite artists.")
                .setImage(R.drawable.logo1)
                .addItem(new Element().setTitle("Version 1.0"))
                .addEmail("dilshantharinduk@gmail.com")
                .create();

        setContentView(aboutPage);
    }
}
