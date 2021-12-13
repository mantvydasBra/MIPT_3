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
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest2() {
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
                allOf(withId(R.id.btnAdd), withText("+"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        4),
                                3),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.btnTwo), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        4),
                                1),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.btnEqual), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        5),
                                3),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.txtCalculatorScreen), withText("2+2\n4.0"),
                        withParent(withParent(withId(R.id.tblLayout))),
                        isDisplayed()));
        textView.check(matches(withText("2+2\n4.0")));

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.btnEight), withText("8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        2),
                                1),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.btnDiv), withText("÷"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        1),
                                3),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.btnFour), withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        3),
                                0),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.btnEqual), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        5),
                                3),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.txtCalculatorScreen), withText("8÷4\n2.0"),
                        withParent(withParent(withId(R.id.tblLayout))),
                        isDisplayed()));
        textView2.check(matches(withText("8÷4\n2.0")));

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.btnNine), withText("9"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        2),
                                2),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatButton10 = onView(
                allOf(withId(R.id.btnMultiply), withText("×"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        2),
                                3),
                        isDisplayed()));
        appCompatButton10.perform(click());

        ViewInteraction appCompatButton11 = onView(
                allOf(withId(R.id.btnFour), withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        3),
                                0),
                        isDisplayed()));
        appCompatButton11.perform(click());

        ViewInteraction appCompatButton12 = onView(
                allOf(withId(R.id.btnSub), withText("-"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        3),
                                3),
                        isDisplayed()));
        appCompatButton12.perform(click());

        ViewInteraction appCompatButton13 = onView(
                allOf(withId(R.id.btnTwo), withText("2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        4),
                                1),
                        isDisplayed()));
        appCompatButton13.perform(click());

        ViewInteraction appCompatButton14 = onView(
                allOf(withId(R.id.btnSqrRoot), withText("√"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        1),
                                4),
                        isDisplayed()));
        appCompatButton14.perform(click());

        ViewInteraction appCompatButton15 = onView(
                allOf(withId(R.id.btnSix), withText("6"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        3),
                                2),
                        isDisplayed()));
        appCompatButton15.perform(click());

        ViewInteraction appCompatButton16 = onView(
                allOf(withId(R.id.btnEqual), withText("="),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tblLayout),
                                        5),
                                3),
                        isDisplayed()));
        appCompatButton16.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.txtCalculatorScreen), withText("9×4-2√6\n31.1010205144"),
                        withParent(withParent(withId(R.id.tblLayout))),
                        isDisplayed()));
        textView3.check(matches(withText("9×4-2√6\n31.1010205144")));
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
