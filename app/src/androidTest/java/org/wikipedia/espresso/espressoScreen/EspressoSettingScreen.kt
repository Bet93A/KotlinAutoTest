package org.wikipedia.espresso.espressoScreen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R

class EspressoSettingScreen {
    private val buttonExploreFeed = withText("Настроить ленту")
    private val buttonAboutTheWikipediaApp = withText("О приложении «Википедия»")
    private val buttonPrivacyPolicy = withText("Политика конфиденциальности")
    private val scroll = withId(R.id.recycler_view)

    fun clickButtonExploreFeed(){
        onView(buttonExploreFeed)
            .perform(click())
    }

    fun clickButtonAboutTheWikipedia(){
        onView(buttonAboutTheWikipediaApp)
            .perform(click())
    }
    fun clickButtonPrivacyPolicy(){
        onView(buttonPrivacyPolicy)
            .perform(click())
    }

    fun scrollToLast() {
        onView(scroll)
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())
    }
}