package bruteforce;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bruteforce.blossom.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.net.ssl.ExtendedSSLSession;

import bruteforce.presentation.LogInActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 Class: AccountManagementTest
 Author: Triet Nguyen
 Purpose: This class executes account management feature acceptance test automatically.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccountManagementTest {
    @Rule
    public ActivityTestRule<LogInActivity> activityRule = new ActivityTestRule<>(LogInActivity.class);

    /**
     Author: Triet Nguyen
     createAccountTest
     Purpose: test create a new account.
     Parameters: none.
     Returns: none.
     */
    @Before
    public void createAccountTest() {
        closeSoftKeyboard();
        onView(withId(R.id.button9)).perform(click());
        onView(withId(R.id.editText7)).perform(typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.editText8)).perform(typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.button10)).perform(click());
        Espresso.pressBack();
    }

    /**
     Author: Triet Nguyen
     loginAccountTest
     Purpose: test login a existed account.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void loginAccountTest() {
        closeSoftKeyboard();
        onView(withId(R.id.editText4)).perform(clearText(),typeText("username2"));
        closeSoftKeyboard();
        onView(withId(R.id.editText5)).perform(clearText(),typeText("password2"));
        closeSoftKeyboard();
        onView(withId(R.id.button7)).perform(click());
        Espresso.pressBack();
        onView(withText("YES"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
    }

    /**
     Author: Triet Nguyen
     updatePasswordTest
     Purpose: test update password.
     Parameters: none.
     Returns: none.
     */
    @After
    public void updatePasswordTest() {
        onView(withId(R.id.editText4)).perform(clearText(),typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.editText5)).perform(clearText(),typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.button7)).perform(click());

        onView(withId(R.id.action_info)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.editText6)).perform(clearText(),typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.button10)).perform(click());

        Espresso.pressBack();
        Espresso.pressBack();
        onView(withText("YES"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.editText4)).perform(clearText(),typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.editText5)).perform(clearText(),typeText("JohnnyTN"));
        closeSoftKeyboard();
        onView(withId(R.id.button7)).perform(click());
        Espresso.pressBack();
        onView(withText("YES"))
                .inRoot(isDialog())
                .check(matches(isDisplayed()))
                .perform(click());
    }




}
