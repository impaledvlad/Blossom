package bruteforce;

import android.support.test.espresso.Espresso;
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
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 Class: PointsSystemTest
 Author: Triet Nguyen
 Purpose: This class executes points system feature acceptance test automatically.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PointsSystemTest {
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
     digitalPlantTest
     Purpose: test Plant watering.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void digitalPlantTest() {
        onData(anything()).inAdapterView(withId(R.id.list1)).atPosition(1).perform(click());
        onView(withId(R.id.checkBox)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.plant_view_btn)).perform(click());
        onView(withId(R.id.button7)).perform(click());
    }
}
