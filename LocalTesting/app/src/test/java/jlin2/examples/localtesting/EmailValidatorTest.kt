package jlin2.examples.localtesting

import org.junit.Assert
import org.junit.Test
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
//        Correct email address format, such as 123@abc.com
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
//        Correct email address subdomain format, such as 123@abc.co.ca
        Assert.assertTrue(EmailValidator.isValidEmail("123@abc.co.ca"))
    }

    @Test
    fun emailValidator_InvalidEmailIncorrectDomain_ReturnsFalse() {
//        Incorrect email address format (incorrect domain), such as 123@abc
        assertFalse(EmailValidator.isValidEmail("123@abc"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDots_ReturnsFalse() {
//        Incorrect email address format (with double dots), such as 123@abc..com
        assertFalse(EmailValidator.isValidEmail("123@abc..com"))
    }
    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
//        Incorrect email address format (without username), such as @abc.comgit
        assertFalse(EmailValidator.isValidEmail("@abc.com"))
    }
    @Test
    fun emailValidator_InvalidEmailNoDomain_ReturnsFalse() {
//        Incorrect email address format (without domain), such as testing123
        assertFalse(EmailValidator.isValidEmail("testing123"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
//        Incorrect email address format (empty string), such as “”
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
//        Incorrect email address format (null), null
        assertFalse(EmailValidator.isValidEmail(null))
    }


}