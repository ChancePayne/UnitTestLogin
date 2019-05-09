package com.lambdaschool.unittestlogin;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class, false, true);
//    public IntentsTestRule<MainActivity>  mainActivityTestRule = new IntentsTestRule<>(MainActivity.class, false, true);

    @Test
    public void mainActivity_EnterDataPassesCheck_ReturnsTrue() {
        onView(withId(R.id.input_email)) // get a handle to the view
                .perform(clearText()) // remove all text from view
                .perform(typeText(MainActivity.MOCKED_EMAIL)); // type text into view

        onView(withId(R.id.input_password))
                .perform(clearText())
                .perform(typeText(MainActivity.MOCKED_PASSWORD));

        onView(withId(R.id.btn_login))
                .perform(click());

        Intents.init();

        intended(hasComponent(AccountDetailsActivity.class.getName()));
    }
}
