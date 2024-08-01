package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityInstrumentedTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    @Test
    fun InstrumentedTest_ChangeTextButtonAndCheckText() {
//        Enter “123” and press Change Text button, and test the string
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.changeTextBt)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }

    @Test

    fun InstrumentedTest_OpenActivityAndChangeTextButton() {
//        Enter “123” and press Open Activity and Change Text button,and test the string in ShowTextActivity
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.show_text_view)).check(matches(withText("123")))
    }

    @Test
    fun InstrumentedTest_ChangeTextButtonWithAbcdef() {
//        Enter “abcdef” and press Change Text button, and test the string
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")))
    }

    @Test
    fun InstrumentedTest_OpenActivityAndChangeTextButtonWithAbcdef() {
//        Enter “abcdef” and press Open Activity and Change Text button, and test the string in ShowTextActivity
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.show_text_view)).check(matches(withText("abcdef")))
    }

    @Test
    fun InstrumentedTest_EmptyTextChangeTextButton() {
//        Without entering anything and press Change Text button and test the string (empty/null)
        onView(withId(R.id.editTextUserInput)).perform(clearText(), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        onView(withId(R.id.textToBeChanged)).check(matches(withText("")))
    }

    @Test
    fun InstrumentedTest_EmptyTextOpenActivityAndChangeTextButton() {
//        Without entering anything and press Open Activity and Change Text button, and test the string in ShowTextActivity
        onView(withId(R.id.editTextUserInput)).perform(clearText(), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())

//        Thread.sleep(2000)

        onView(withId(R.id.show_text_view)).check(matches(isDisplayed()))

        onView(withId(R.id.show_text_view)).check(matches(withText("")))
    }


}