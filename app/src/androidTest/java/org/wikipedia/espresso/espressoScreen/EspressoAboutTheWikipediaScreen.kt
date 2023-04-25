package org.wikipedia.espresso.espressoScreen

import android.widget.LinearLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.wikipedia.R

class EspressoAboutTheWikipediaScreen {
    private val contributors = withId(R.id.about_contributors)
    private val translators =withId(R.id.about_translators)
    private val license = withId(R.id.about_app_license)
    private val matcherParent = withParent(instanceOf(LinearLayout::class.java))


    fun checkBlockContribetors() {
        onView(
            allOf(matcherParent, contributors))
            .check(matches(isDisplayed()))
    }

    fun checkBlockTranslators() {
        onView(
            allOf(matcherParent, translators))
            .check(matches(isDisplayed()))
    }

    fun checkBlockLicense() {
        onView(
            allOf(matcherParent, license ))
            .check(matches(isDisplayed()))
    }
}