package com.example.mipt_3;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.btnTwo), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        4),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.btnTwo), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        4),
                                1),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.btnDel),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        1),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.txtCalculatorScreen), withText("2"),
                        withParent(withParent(withId(R.id.tblLayout))),
                        isDisplayed()));
        textView.check(matches(withText("2")));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnThree), withText("3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        4),
                                2),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnFive), withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        3),
                                1),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnFive), withText("5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        3),
                                1),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withId(R.id.btnDel),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        1),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withId(R.id.btnDel),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        1),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtCalculatorScreen), withText("23"),
                        withParent(withParent(withId(R.id.tblLayout))),
                        isDisplayed()));
        textView2.check(matches(withText("23")));

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnDot), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        5),
                                2),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnDot), withText("."),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        5),
                                2),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withId(R.id.btnDel),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        1),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtCalculatorScreen), withText("23"),
                        withParent(withParent(withId(R.id.tblLayout))),
                        isDisplayed()));
        textView3.check(matches(withText("23")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
