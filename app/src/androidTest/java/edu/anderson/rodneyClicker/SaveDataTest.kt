package edu.anderson.rodneyClicker

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.doubleClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SaveDataTest {
    @get:Rule
    var rule = activityScenarioRule<MainActivity>()

    @Test
    fun saveData() {
        // Confirm that Raven Dollars start at zero
        onView(withId(R.id.ravenDollars)).check(matches(withText("R$0")))

        // Click the button
        onView(withId(R.id.ravenButton)).perform(doubleClick())
        onView(withId(R.id.ravenButton)).perform(doubleClick())

        // Confirm that value increments
        onView(withId(R.id.ravenDollars)).check(matches(withText("R$4")))

        // Recreate activity
        rule.scenario.close()
        launch(MainActivity::class.java)

        // Check to see if the value is saved
        onView(withId(R.id.ravenDollars)).check(matches(withText("R$4")))
    }
}
