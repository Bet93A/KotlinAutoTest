package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.wikipedia.R

class EspressoFirstScreen{
    private val buttonSkip = withId(R.id.fragment_onboarding_skip_button)

    fun clickButtonSkip(){
        onView(buttonSkip)
            .perform(click())
    }
}