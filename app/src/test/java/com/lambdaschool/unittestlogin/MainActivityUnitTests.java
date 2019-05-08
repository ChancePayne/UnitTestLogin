package com.lambdaschool.unittestlogin;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MainActivityUnitTests {
    @Test
    public void mainActivity_LoginValidationSuccess_ReturnsTrue() {
        assertTrue(MainActivity.checkLogin(MainActivity.MOCKED_EMAIL, MainActivity.MOCKED_PASSWORD));
    }

    @Test
    public void mainActivity_LoginValidationInvalidEmail_ReturnsFalse() {
        assertFalse(MainActivity.checkLogin("asdfasdfasdf", MainActivity.MOCKED_PASSWORD));
    }

    @Test
    public void mainActivity_LoginValidationBadEmail_ReturnsFalse() {
        assertFalse(MainActivity.checkLogin("test@gmail.com", MainActivity.MOCKED_PASSWORD));
    }

    @Test
    public void mainActivity_LoginValidationBadPassword_ReturnsFalse() {
        assertFalse(MainActivity.checkLogin(MainActivity.MOCKED_EMAIL, "123456789"));
    }

    @Test
    public void mainActivity_LoginValidationBadBoth_ReturnsFalse() {
        assertFalse(MainActivity.checkLogin("test@gmail.com", "123456789"));
    }
}
