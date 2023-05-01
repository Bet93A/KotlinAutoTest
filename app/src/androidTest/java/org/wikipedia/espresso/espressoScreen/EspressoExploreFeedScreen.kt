package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class EspressoExploreFeedScreen {
    private val listCheckboxPage = arrayListOf(
        R.string.view_top_read_card_title,
        R.string.view_featured_image_card_title,
        R.string.view_because_you_read_card_title,
        R.string.view_card_news_title,
        R.string.on_this_day_card_title,
        R.string.view_random_card_title,
        R.string.view_main_page_card_title
    )

    fun checkPage(){
        for( i in listCheckboxPage){
            onView(allOf(
                hasSibling(withChild(withText(i))),
                withId(R.id.feed_content_type_checkbox)))
                .check(matches(isChecked()))
                .perform(swipeUp())
        }
    }
}