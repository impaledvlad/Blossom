package bruteforce;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.bruteforce.blossom.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import bruteforce.presentation.LogInActivity;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 Class: StatisticsTest
 Author: Triet Nguyen
 Purpose: This class executes statistics feature acceptance test automatically.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class StatisticsTest {
    @Rule
    public ActivityTestRule<LogInActivity> activityRule = new ActivityTestRule<>(LogInActivity.class);

    /**
     Author: Triet Nguyen
     loginAccount
     Purpose: setup account.
     Parameters: none.
     Returns: none.
     */
    @Before
    public void loginAccount() {
        closeSoftKeyboard();
        onView(withId(R.id.editText4)).perform(clearText(),typeText("username3"));
        closeSoftKeyboard();
        onView(withId(R.id.editText5)).perform(clearText(),typeText("password3"));
        closeSoftKeyboard();
        onView(withId(R.id.button7)).perform(click());

    }

    /**
     Author: Triet Nguyen
     summaryTest
     Purpose: check information of statistics feature.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void summaryTest() {
        onView(withId(R.id.summary_btn)).perform(click());
    }
}
