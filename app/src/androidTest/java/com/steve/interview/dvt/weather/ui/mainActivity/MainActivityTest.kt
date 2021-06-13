package com.steve.interview.dvt.weather.ui.mainActivity

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.steve.interview.dvt.weather.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testt() {

        val testText = "Hello"
        onView(withId(R.id.mainTemperature)).perform(setTextInTextView(testText))
        onView(withId(R.id.mainTemperature)).check(matches(withText(testText)))
    }

    fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(TextView::class.java))
            }

            override fun perform(uiController: UiController, view: View) {
                (view as TextView).text = value
            }

            override fun getDescription(): String {
                return "change textView text"
            }
        }
    }
}
