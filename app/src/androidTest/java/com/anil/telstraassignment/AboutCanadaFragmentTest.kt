package com.anil.telstraassignment

import android.content.Intent
import android.support.test.espresso.Espresso
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import com.anil.telstraassignment.ui.aboutcanada.AboutCanadaActivity
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.not
import org.junit.*
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WeatherFragmentTest {

    @get:Rule
    val activityRule = ActivityTestRule(AboutCanadaActivity::class.java)

    private var aboutCanadaActivity: AboutCanadaActivity? = null

    private lateinit var mockWebServer: MockWebServer

    @Before
    @Throws(Exception::class)
    fun setUp() {

        mockWebServer = MockWebServer()
        mockWebServer.start(8080)

        aboutCanadaActivity = activityRule.activity

    }

    @Test
    fun launch_about_canada_activity_test() {

        activityRule.launchActivity(Intent())

        Assert.assertNotNull(aboutCanadaActivity?.findViewById(R.id.parent))
    }

    @Test
    fun test_success_condition() {

        Espresso.onView(withId(R.id.iv_loader)).check(matches(not<View>(isDisplayed())))
        Espresso.onView(withId(R.id.rv_about_canada)).check(matches(isDisplayed()))
        Espresso.onView(withId(R.id.toolbar_common)).check(matches(hasDescendant(withText("About Canada"))))

    }

    @Test
    fun test_recycler_view_items_nonzero() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_about_canada))
            .check(ViewAssertions.matches(ViewMatchers.hasMinimumChildCount(1)))
    }


    @After
    @Throws(Exception::class)
    fun tearDown() {

        aboutCanadaActivity = null

        mockWebServer.shutdown()

    }
}