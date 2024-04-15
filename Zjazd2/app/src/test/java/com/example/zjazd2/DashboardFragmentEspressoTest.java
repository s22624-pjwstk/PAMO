package com.example.zjazd2;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import com.example.zjazd2.MainActivity;
import com.example.zjazd2.R;

public class DashboardFragmentEspressoTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCalculateBMI() {
        // Wprowadź dane do pól tekstowych
        Espresso.onView(ViewMatchers.withId(R.id.weight)).perform(ViewActions.replaceText("70"));
        Espresso.onView(ViewMatchers.withId(R.id.height)).perform(ViewActions.replaceText("1.75"));

        // Kliknij przycisk Oblicz
        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click());

        // Sprawdź, czy tekst wyniku zawiera oczekiwany wzorzec
        Espresso.onView(ViewMatchers.withId(R.id.result))
                .check(ViewAssertions.matches(ViewMatchers.withText("Your BMI is: \\d+\\.\\d+")));
    }
}