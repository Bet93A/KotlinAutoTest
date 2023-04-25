package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText

class EspressoMainScreen {
    private val buttonMore = withText("Ещё")
    private val buttonSetting = withText("Настройки")
    private val buttonSignIn = withText("ВОЙТИ В ВИКИПЕДИЮ")

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