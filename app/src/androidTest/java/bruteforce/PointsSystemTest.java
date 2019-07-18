package bruteforce;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;

import com.bruteforce.blossom.R;

import org.hamcrest.Matchers;
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
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
        onView(withId(R.id.button)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.editText)).perform(typeText("testTask"));
        closeSoftKeyboard();
        onView(withId(R.id.radioButton18)).perform(click());
        onView(withId(R.id.textView3)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020,12,31));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.button3)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.list1)).atPosition(0).perform(click());
        onView(withId(R.id.checkBox)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.plant_view_btn)).perform(click());
        onView(withId(R.id.button7)).perform(click());
    }
}
