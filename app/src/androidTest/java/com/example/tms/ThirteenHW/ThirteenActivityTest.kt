package com.example.tms.ThirteenHW

import android.app.Activity
import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*

import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.tms.R
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4ClassRunner::class)
class ThirteenActivityTest{
    private lateinit var activityScenario: ActivityScenario<ThirteenActivity>
    @Before
    fun setUp(){
        activityScenario=ActivityScenario.launch(ThirteenActivity::class.java)
    }
    @Test
    fun inputText_returnsTrue() {
        onView(withId(R.id.inputText_fibonacci)).perform(typeText("14")).check(
            matches(withText(R.string.fourteen))
        )

    }
    @Test
    fun basicInput_returnsTrue() {
        val fibNum=Fibonacci.getNumber(14).toString()
        onView(withId(R.id.inputText_fibonacci)).perform(typeText("14"))
        androidx.test.espresso.Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_fibonacci)).perform(click())
        onView(withId(R.id.textView_fibonacci)).check(
            matches(withText(fibNum))
        )

    }
    @Test
    fun emptyInput_returnsTrue() {
        onView(withId(R.id.button_fibonacci)).perform(click())
        onView(withId(R.id.textView_fibonacci)).check(
            matches(withText("0"))
        )

    }

}
