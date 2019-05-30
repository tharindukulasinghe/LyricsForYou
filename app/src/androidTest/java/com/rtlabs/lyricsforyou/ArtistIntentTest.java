package com.rtlabs.lyricsforyou;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.filters.LargeTest;

import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ArtistIntentTest {

    private static final String MESSAGE = "micheal";
    private static final String PACKAGE_NAME = "com.rtlabs.lyricsforyou";

    /* Instantiate an IntentsTestRule object. */
    @Rule
    public IntentsTestRule<MainActivity> intentsRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void verifyMessageSentToMessageActivity() {

        intended(allOf(
                hasComponent(hasShortClassName(".ArtistSongsScreen")),
                toPackage(PACKAGE_NAME),
                IntentMatchers.hasExtra("genre", MESSAGE)));
    }
}
