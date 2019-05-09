package com.lambdaschool.unittestlogin;

import android.app.Activity;
import android.content.Intent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class AccountDetailsActivityTest {

    private User user;

    @Rule
    public ActivityTestRule<AccountDetailsActivity> detailsActivityTestRule = new ActivityTestRule<>(
            AccountDetailsActivity.class, false, false);

    @Before
    public void setUp() {
        user = new User("Shark", "myUser", "test@gmail.com", "Bill", "Waters");

        Intent intent = new Intent();
        intent.putExtra(User.TAG, user);

        detailsActivityTestRule.launchActivity(intent);
    }

    @Test
    public void detailsActivity_DisplayUserName_ReturnsTrue() {
        onView(withId(R.id.text_username)).check(matches(withText(user.getUsername())));
    }

    @Test
    public void detailsActivity_DisplayFavoriteAnimal_ReturnsTrue(){
        onView(withId(R.id.text_favorite_animal)).check(matches(withText(user.getFavoriteAnimal())));
    }

    @Test
    public void detailsActivity_DisplayEmail_ReturnsTrue() {
        Espresso.onView(
                ViewMatchers.withId(R.id.text_email)).check(
                        ViewAssertions.matches(
                                ViewMatchers.withText(user.getEmail())));
    }

    @Test
    public void detailsActivity_DisplayName_ReturnsTrue() {
        onView(withId(R.id.text_display_name)).check(matches(withText(user.getDisplayName())));
    }

}