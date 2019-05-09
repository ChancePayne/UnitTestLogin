package com.lambdaschool.unittestlogin;

import android.app.Activity;
import android.content.Intent;

import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountDetailsActivityTest {

    private User user;

    @Rule
    ActivityTestRule<AccountDetailsActivity> detailsActivityTestRule = new ActivityTestRule<>(
            AccountDetailsActivity.class, false, false);

    @Before
    public void setUp() throws Exception {
        user = new User("Shark", "myUser", "test@gmail.com", "Bill", "Waters");

        Intent intent = new Intent();
        intent.putExtra(User.TAG, user);

        detailsActivityTestRule.launchActivity(intent);
    }

}