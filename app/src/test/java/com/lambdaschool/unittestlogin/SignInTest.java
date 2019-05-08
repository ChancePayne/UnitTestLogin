package com.lambdaschool.unittestlogin;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowLooper;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class SignInTest {

    private MainActivity mainActivity = null;

    @Before
    public void setup() {
        mainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void mainActivity_SignInProgressIndicatorShown() {
        mainActivity.doLogin();
        assertThat(mainActivity.progressDialog.isShowing(), equalTo(true));
    }

    @Test
    // test not working properly
    public void mainActivity_SignInProgressIndicatorDisappears() {
        mainActivity.doLogin();

        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        assertThat(mainActivity.progressDialog.isShowing(), equalTo(false));
    }

    @Test
//    emailValidator_CorrectEmailSimple_ReturnsTrue
    public void mainActivity_SuccessfulSignIn() {

        mainActivity.inputEmail.setText(MainActivity.MOCKED_EMAIL);
        mainActivity.inputPassword.setText(MainActivity.MOCKED_PASSWORD);

        mainActivity.doLogin();

        // Tells Robolectric to wait until our handler is completed
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        assertThat(mainActivity.successSnackBar.isShown(), equalTo(true));
        assertThat(mainActivity.failureSnackBar.isShown(), equalTo(false));
//        assertTrue(mainActivity.successSnackBar.isShown());
    }

    @Test
    public void mainActivity_UnSuccessfulSignIn() {

        mainActivity.inputEmail.setText(MainActivity.MOCKED_EMAIL);
        mainActivity.inputPassword.setText("BADPASSWORD");

        mainActivity.doLogin();

        // Tells Robolectric to wait until our handler is completed
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();

        assertThat(mainActivity.successSnackBar.isShown(), equalTo(false));
        assertThat(mainActivity.failureSnackBar.isShown(), equalTo(true));
//        assertTrue(mainActivity.successSnackBar.isShown());
    }
}
