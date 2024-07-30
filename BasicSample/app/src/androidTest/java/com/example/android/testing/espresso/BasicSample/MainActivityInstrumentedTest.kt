package com.example.android.testing.espresso.BasicSample

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
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
}