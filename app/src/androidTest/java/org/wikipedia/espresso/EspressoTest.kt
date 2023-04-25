package org.wikipedia.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.wikipedia.espresso.espressoScreen.EspressoAboutTheWikipediaScreen
import org.wikipedia.espresso.espressoScreen.EspressoExploreFeedScreen
import org.wikipedia.espresso.espressoScreen.EspressoFirstScreen
import org.wikipedia.espresso.espressoScreen.EspressoMainScreen
import org.wikipedia.espresso.espressoScreen.EspressoSettingScreen
import org.wikipedia.main.MainActivity

class EspressoTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

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
        exploreFeedScreen.checkFirstPage()
        exploreFeedScreen.scrollToLast()
        exploreFeedScreen.checkSecondPage()
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
        aboutTheWikipediaScreen.checkBlockContribetors()
        aboutTheWikipediaScreen.checkBlockTranslators()
        aboutTheWikipediaScreen.checkBlockLicense()
    }
}