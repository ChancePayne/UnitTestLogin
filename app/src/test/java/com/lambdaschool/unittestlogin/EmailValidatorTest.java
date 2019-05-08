package com.lambdaschool.unittestlogin;

import android.provider.ContactsContract;

import com.lambdaschool.unittestlogin.util.EmailValidator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidatorTest {

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"));
    }

    @Test
    public void emailValidator_NoAtSymbol_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("nameemail.com"));
    }

    @Test
    public void emailValidator_NoDotCom_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidator_NoDotComOrAt_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("nameemail"));
    }

    @Test
    public void emailValidator_InvalidCharacters_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name(theBest)@email.com"));
    }

    @Test
    public void emailValidator_CorrectEmailTwoDots_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.jp"));
    }

    @Test
    public void emailValidator_NoAt_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("nameATemail.com"));
    }

    @Test
    public void emailValidator_NoPeriod_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@emailDOTcom"));
    }

    @Test
    public void emailValidator_NothingAfterPeriod_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email."));
    }

    @Test
    public void emailValidator_NameBeforeAt_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"));
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}
