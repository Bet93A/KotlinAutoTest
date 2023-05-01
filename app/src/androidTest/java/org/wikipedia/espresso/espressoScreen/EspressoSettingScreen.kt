package org.wikipedia.espresso.espressoScreen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R


class EspressoSettingScreen {
    private val buttonExploreFeed = withText(R.string.preference_summary_customize_explore_feed)
    private val buttonAboutTheWikipediaApp = withText(R.string.about_description)
    private val buttonPrivacyPolicy = withText(R.string.privacy_policy_description)

    fun clickButtonExploreFeed(){
        onView(buttonExploreFeed)
            .perform(click())
    }

    fun clickButtonAboutTheWikipedia(){
        onView(buttonAboutTheWikipediaApp)
            .perform(click())
    }

    fun scrollToLast(){
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())
    }

    fun clickButtonPrivacyPolicy() {
        Intents.init()
        onView(buttonPrivacyPolicy)
            .perform(click())
        intended(toPackage("com.android.chrome"))
        Intents.release()
    }
}