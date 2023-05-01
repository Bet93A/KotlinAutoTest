package org.wikipedia.espresso.espressoScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasTextColor
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R


class EspressoLoginScreen {
    private val passValue = "12345678"
    private val fieldPass = withHint(R.string.account_creation_password_hint)
    private val buttonEye = allOf(
        isDescendantOfA(withId(R.id.create_account_password_input)),
        withId(com.google.android.material.R.id.text_input_end_icon)
    )
    private val fieldName = withHint(R.string.create_account_username_hint)
    private val buttonNext = withId(R.id.create_account_submit_button)
    private val textError = withText(R.string.create_account_password_error)
    private val color = hasTextColor(R.color.red500)
    private val color2 = hasTextColor(R.color.red700)

    fun inputPass(pass: String) {
        onView(fieldPass)
            .perform(click(), replaceText(pass))
    }

    fun inputName(name: String) {
        onView(fieldName)
            .perform(click(), replaceText(name))
    }

    fun clickButtonNext() {
        onView(buttonNext)
            .perform(click())
    }

    fun clickButtonEye() {
        onView(buttonEye)
            .perform(click())
    }

    fun checkFieldPassOpen(pass: String){
        onView(withHint(R.string.account_creation_password_hint))
            .check(matches(withText(pass)))
    }
    fun checkRedError() {
        onView(allOf(textError, anyOf(color, color2)))
            .check(matches(isDisplayed()))
    }
}