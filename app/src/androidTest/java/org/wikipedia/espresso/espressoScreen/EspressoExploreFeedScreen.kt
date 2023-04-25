package org.wikipedia.espresso.espressoScreen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.wikipedia.R

class EspressoExploreFeedScreen {
    private val listCheckboxOnePage = arrayListOf<String>("Самое читаемое", "Изображение дня","На основе прочитанного",
        "В новостях", "В этот день")
    private val listCheckboxTwoPage = arrayListOf<String>("Рандомизатор","Сегодня в Википедии")
    private val scroll = withId(R.id.content_types_recycler)

    fun checkFirstPage(){
        for( i in listCheckboxOnePage){
            onView(allOf(
                hasSibling(withChild(withText(i.toString()))),
                withId(R.id.feed_content_type_checkbox)))
                .check(matches(isChecked()))
        }
    }

    fun checkSecondPage(){
        for( i in listCheckboxTwoPage){
            onView(allOf(
                hasSibling(withChild(withText(i.toString()))),
                withId(R.id.feed_content_type_checkbox)))
                .check(matches(isChecked()))
        }
    }

    fun scrollToLast(){
        onView(scroll)
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())
    }
}