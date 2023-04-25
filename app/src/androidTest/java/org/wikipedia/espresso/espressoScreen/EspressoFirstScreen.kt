package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.anyOf

class EspressoFirstScreen{
    private val buttonSkipRus = withText("Пропустить")
    private val buttonSkipEng = withText("Skip")

    fun clickButtonSkip(){
        onView(anyOf(buttonSkipRus,buttonSkipEng))
            .perform(click())
    }
}