package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class EspressoMainScreen {
    private val buttonMore = withId(R.id.nav_more_container)
    private val buttonSetting = withId(R.id.main_drawer_settings_container)
    private val buttonSignIn = withId(R.id.main_drawer_login_button)

    fun clickButtonMore(){
        onView(buttonMore)
            .perform(click())
    }

    fun clickButtonSetting(){
        onView(buttonSetting)
            .perform(click())
    }

    fun clickButtonSignIn(){
        onView(buttonSignIn)
            .perform(click())
    }
}