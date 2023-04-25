package org.wikipedia.espresso

import android.os.SystemClock
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import org.wikipedia.R
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasCategories
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.hasSibling
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.supportsInputMethods
import androidx.test.espresso.matcher.ViewMatchers.withChild
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf
import org.junit.Rule
import org.junit.Test
import org.wikipedia.main.MainActivity

class EspressoKotlinTest{
    @get:Rule
    val activityRule =ActivityScenarioRule(MainActivity::class.java)
    val intentsTestRule = IntentsTestRule(MainActivity::class.java)
    val timeout = 2000L
    @Test
    fun twoTest() {
        onView(withText("Пропустить")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Ещё")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Настройки"))
            .perform((ViewActions.click()))
        //.perform(ViewActions.swipeUp())

        //onView(withText("О приложении «Википедия»"))//.perform(scrollTo(), click())
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())

        onView(withText("О приложении «Википедия»"))
            .perform(ViewActions.click())

        onView(
            allOf(
                withParent(instanceOf(LinearLayout::class.java)),
                withId(R.id.about_contributors)
            )
        )
            .check(matches(isDisplayed()))

        onView(
            allOf(
                withParent(instanceOf(LinearLayout::class.java)),
                withId(R.id.about_translators)
            )
        )
            .check(matches(isDisplayed()))

        onView(
            allOf(
                withParent(instanceOf(LinearLayout::class.java)),
                withId(R.id.about_app_license)
            )
        )
            .check(matches(isDisplayed()))
    }
    @Test
    fun oneTest() {
        onView(withText("Пропустить")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Ещё")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Настройки"))
            .perform((ViewActions.click()))

        onView(withText("Настроить ленту"))
            .perform(click())

        SystemClock.sleep(1000)

        onView(
            allOf(
                hasSibling(withChild(withText("Избранная статья"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(
            allOf(
                hasSibling(withChild(withText("Самое читаемое"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(
            allOf(
                hasSibling(withChild(withText("Изображение дня"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(
            allOf(
                hasSibling(withChild(withText("На основе прочитанного"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(
            allOf(
                hasSibling(withChild(withText("В новостях"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(
            allOf(
                hasSibling(withChild(withText("В этот день"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(withId(R.id.content_types_recycler))
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())

        onView(
            allOf(
                hasSibling(withChild(withText("Рандомизатор"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

        onView(
            allOf(
                hasSibling(withChild(withText("Сегодня в Википедии"))),
                withId(R.id.feed_content_type_checkbox)
            )
        )
            .check(matches(isChecked()))

    }

    @Test
    fun thirdTest() {
        onView(withText("Пропустить")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Ещё")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Настройки"))
            .perform((ViewActions.click()))

        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions.scrollToLastPosition<RecyclerView.ViewHolder>())

        onView(withText("Политика конфиденциальности"))
            .perform((ViewActions.click()))
        Intents.init()
        intended(toPackage("com.android.chrome"))
        Intents.release()
    }

    @Test
    fun fourTest(){
        onView(withText("Пропустить")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("Ещё")) //nav_more_container
            .perform(ViewActions.click())
        onView(withText("ВОЙТИ В ВИКИПЕДИЮ"))
            .perform((ViewActions.click()))
        onView(withText("Пароль"))
            .perform(click(), replaceText("12345678"))
        //onView(allOf(withParent(withId( R.id.create_account_password_input)), withId(com.google.android.material.R.id.text_input_end_icon)))
          //  .perform(click())

            //.perform(ViewActions.click())
            //.perform(ViewActions.click())
            //.perform((ViewActions.click()))
        //onView(allOf(withId(R.id.feed_content_type_checkbox), withParent(withText("Избранная статья"))))
          //  .check(matches(isChecked()))

    }
}


