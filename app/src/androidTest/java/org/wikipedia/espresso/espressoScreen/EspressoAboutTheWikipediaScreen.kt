package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R

class EspressoAboutTheWikipediaScreen {
    private val dataContributors = withId(R.id.about_contributors)
    private val dataTranslators =withId(R.id.about_translators)
    private val dataLicense = withId(R.id.about_app_license)
    private val headerContributors = withText(R.string.about_contributors_heading)
    private val headerTranslators = withText(R.string.about_translators_heading)
    private val headerLicense = withText(R.string.about_app_license_heading)



    fun checkBlockContribetors() {
        onView(dataContributors)
            .check(matches(isDisplayed()))
        onView(headerContributors)
            .check(matches(isDisplayed()))
    }

    fun checkBlockTranslators() {
        onView(dataTranslators)
            .check(matches(isDisplayed()))
        onView(headerTranslators)
            .check(matches(isDisplayed()))
    }

    fun checkBlockLicense() {
        onView(dataLicense)
            .check(matches(isDisplayed()))
        onView(headerLicense)
            .check(matches(isDisplayed()))
    }
}