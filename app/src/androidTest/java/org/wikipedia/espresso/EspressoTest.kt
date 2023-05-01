package org.wikipedia.espresso

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.espresso.espressoScreen.EspressoAboutTheWikipediaScreen
import org.wikipedia.espresso.espressoScreen.EspressoExploreFeedScreen
import org.wikipedia.espresso.espressoScreen.EspressoFirstScreen
import org.wikipedia.espresso.espressoScreen.EspressoLoginScreen
import org.wikipedia.espresso.espressoScreen.EspressoMainScreen
import org.wikipedia.espresso.espressoScreen.EspressoSettingScreen
import org.wikipedia.main.MainActivity

class EspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    val intentsRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun oneTest() {
        val firstScreen = EspressoFirstScreen()
        val mainScreen = EspressoMainScreen()
        val settingScreen = EspressoSettingScreen()
        val exploreFeedScreen = EspressoExploreFeedScreen()

        firstScreen.clickButtonSkip()
        mainScreen.clickButtonMore()
        mainScreen.clickButtonSetting()
        settingScreen.clickButtonExploreFeed()
        Thread.sleep(500)
        exploreFeedScreen.checkPage()
    }

    @Test
    fun twoTest(){
        val firstScreen = EspressoFirstScreen()
        val mainScreen = EspressoMainScreen()
        val settingScreen = EspressoSettingScreen()
        val aboutTheWikipediaScreen = EspressoAboutTheWikipediaScreen()

        firstScreen.clickButtonSkip()
        mainScreen.clickButtonMore()
        mainScreen.clickButtonSetting()
        settingScreen.scrollToLast()
        settingScreen.clickButtonAboutTheWikipedia()
        with(aboutTheWikipediaScreen) {
            checkBlockContribetors()
            checkBlockTranslators()
            checkBlockLicense()
        }
    }

    @Test
    fun thirdTest() {
        val firstScreen = EspressoFirstScreen()
        val mainScreen = EspressoMainScreen()
        val settingScreen = EspressoSettingScreen()

        firstScreen.clickButtonSkip()
        mainScreen.clickButtonMore()
        mainScreen.clickButtonSetting()
        settingScreen.scrollToLast()
        settingScreen.clickButtonPrivacyPolicy()
    }

    @Test
    fun fourTest() {
        val firstScreen = EspressoFirstScreen()
        val mainScreen = EspressoMainScreen()
        val loginScreen = EspressoLoginScreen()
        val pass = "12345678"

        firstScreen.clickButtonSkip()
        mainScreen.clickButtonMore()
        mainScreen.clickButtonSignIn()
        loginScreen.inputPass(pass)
        loginScreen.clickButtonEye()
        loginScreen.checkFieldPassOpen(pass)
    }
    @Test
    fun fiveTest(){
        val firstScreen = EspressoFirstScreen()
        val mainScreen = EspressoMainScreen()
        val loginScreen = EspressoLoginScreen()
        val name = "asdfghjjkklxcvbnmqweryuiopf"
        val pass = "12345"

        firstScreen.clickButtonSkip()
        mainScreen.clickButtonMore()
        mainScreen.clickButtonSignIn()
        with(loginScreen){
            inputName(name)
            inputPass(pass)
            clickButtonNext()
            checkRedError()
        }
    }
}