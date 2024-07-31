package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
    fun testChangeTextButton() {
        // Enter text into EditText and press Change Text button
        Espresso.onView(ViewMatchers.withId(R.id.editTextUserInput))
            .perform(ViewActions.typeText("123"), ViewActions.closeSoftKeyboard())
        Espresso.onView(ViewMatchers.withId(R.id.changeTextBt)).perform(ViewActions.click())

        // Verify the text in the TextView
        Espresso.onView(ViewMatchers.withId(R.id.textToBeChanged))
            .check(ViewAssertions.matches(ViewMatchers.withText("123")))
    }

    @Test
    fun testOpenActivityAndChangeTextButton() {
        onView(withId(R.id.editTextUserInput)).perform(typeText("123"), closeSoftKeyboard())
        onView(withId(R.id.activityChangeTextBtn)).perform(click())
        onView(withId(R.id.show_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.show_text_view)).check(matches(withText("123")))
    }
    @Test
    fun testChangeTextButtonWithAbcdef() {
        //Enter “abcdef” and press Change Text button, and test the string
        onView(withId(R.id.editTextUserInput)).perform(typeText("abcdef"), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())
        onView(withId(R.id.textToBeChanged)).check(matches(withText("abcdef")))
    }
}