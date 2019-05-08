package com.lambdaschool.unittestlogin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class SignInTest {

    private MainActivity mainActivity = null;

    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
//    emailValidator_CorrectEmailSimple_ReturnsTrue
    public void mainActivity_SuccessfulSignIn() {

        mainActivity.inputEmail.setText(MainActivity.MOCKED_EMAIL);
        mainActivity.inputPassword.setText(MainActivity.MOCKED_PASSWORD);

        mainActivity.doLogin();

        assertThat(mainActivity.snackBar.isShown(), equalTo(true));
//        assertTrue(mainActivity.snackBar.isShown());
    }
}
