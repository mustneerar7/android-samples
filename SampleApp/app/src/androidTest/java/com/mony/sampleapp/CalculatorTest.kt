package com.mony.sampleapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    /* Runs the [MainActivity]. */
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    /* Automates series of steps and validates results. */
    @Test
    fun calculate20percentTip(){

        onView(withId(R.id.costEditText))
            .perform(typeText("323"))
            .perform(ViewActions.closeSoftKeyboard())

        onView(withId(R.id.one))
            .perform(click())

        onView(withId(R.id.roundupSwitch))
            .perform(click())

        onView(withId(R.id.calculateTipButton))
            .perform(click())

        onView(withId(R.id.total))
            .check(matches(withText(containsString("65.0"))))
    }
}