package com.ismail.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*


import com.ismail.moviecatalogue.R
import com.ismail.moviecatalogue.utils.DataDummy
import com.ismail.moviecatalogue.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test


class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvshow = DataDummy.generateDummyTvShow()


    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }


    @Test
    fun loadMovies() {
        onView(withId(R.id.navigation_movie)).perform(ViewActions.click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
        ))

    }


    @Test
    fun loadTvShows() {
        onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvshow.size
        ))

    }

    @Test
    fun toDetailMovie() {
        onView(withId(R.id.navigation_movie)).perform(ViewActions.click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyMovie[0].title)))

        onView(withId(R.id.text_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating)).check(matches(withText(dummyMovie[0].rating)))

        onView(withId(R.id.text_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration)).check(matches(withText(dummyMovie[0].duration)))

        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(withText(dummyMovie[0].date)))

        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(withText(dummyMovie[0].genre)))

        onView(withId(R.id.text_director)).check(matches(isDisplayed()))
        onView(withId(R.id.text_director)).check(matches(withText(dummyMovie[0].director)))

        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyMovie[0].description)))

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun toDetailTvShow() {
        onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
        )
        )

        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_title)).check(matches(withText(dummyTvshow[0].title)))

        onView(withId(R.id.text_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating)).check(matches(withText(dummyTvshow[0].rating)))

        onView(withId(R.id.text_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration)).check(matches(withText(dummyTvshow[0].duration)))

        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(withText(dummyTvshow[0].date)))

        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(withText(dummyTvshow[0].genre)))

        onView(withId(R.id.text_director)).check(matches(isDisplayed()))
        onView(withId(R.id.text_director)).check(matches(withText(dummyTvshow[0].director)))

        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(dummyTvshow[0].description)))

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun toFavoritedMovies() {
        onView(withId(R.id.navigation_movie)).perform(ViewActions.click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
        ))
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.navigation_favorit)).perform(ViewActions.click())

        onView(withId(R.id.rv_favorited_movie)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_favorited_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_director)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(isRoot()).perform(ViewActions.pressBack())

    }

    @Test
    fun toFavoritedTvShow() {
        onView(withId(R.id.navigation_tvshow)).perform(ViewActions.click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
        ))
        onView(withId(R.id.action_favorite)).perform(ViewActions.click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.navigation_favorit)).perform(ViewActions.click())
        onView(withText("TV SHOW")).perform(ViewActions.click())

        onView(withId(R.id.rv_favorited_tvshow)).check(matches(isDisplayed()))

        onView(withId(R.id.rv_favorited_tvshow)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        ViewActions.click()
                )
        )
        onView(withId(R.id.text_title)).check(matches(isDisplayed()))
        onView(withId(R.id.text_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.text_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.text_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.text_director)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()))
        onView(isRoot()).perform(ViewActions.pressBack())

    }


}