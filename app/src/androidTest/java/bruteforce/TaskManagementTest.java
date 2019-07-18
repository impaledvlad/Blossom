package bruteforce;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;
import android.support.test.espresso.contrib.PickerActions;

import com.bruteforce.blossom.R;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import bruteforce.application.Services;
import bruteforce.business.AccessAccount;
import bruteforce.business.AccessTask;
import bruteforce.objects.Task;
import bruteforce.persistence.AccountPersistence;
import bruteforce.persistence.TaskPersistence;
import bruteforce.persistence.hsqldb.AccountPersistenceHSQLDB;
import bruteforce.persistence.hsqldb.TaskPersistenceHSQLDB;
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
 Class: TaskManagementTest
 Author: Triet Nguyen
 Purpose: This class executes task management feature acceptance test automatically.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TaskManagementTest {

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
        onView(withId(R.id.editText4)).perform(clearText(),typeText("username2"));
        closeSoftKeyboard();
        onView(withId(R.id.editText5)).perform(clearText(),typeText("password2"));
        closeSoftKeyboard();
        onView(withId(R.id.button7)).perform(click());

    }

    /**
     Author: Triet Nguyen
     addTaskTest
     Purpose: test add new task.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void addTaskTest() {
        onView(withId(R.id.button)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.editText)).perform(typeText("testTask"));
        closeSoftKeyboard();
        onView(withId(R.id.radioButton18)).perform(click());
        onView(withId(R.id.textView3)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(2020,12,31));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.button3)).perform(click());
    }

    /**
     Author: Triet Nguyen
     updateTaskTest
     Purpose: test update current task .
     Parameters: none.
     Returns: none.
     */
    @Test
    public void updateTaskTest() {
        onData(anything()).inAdapterView(withId(R.id.list1)).atPosition(0).perform(click());
        onView(withId(R.id.button5)).perform(click());
        onView(withId(R.id.editText2)).perform(clearText(),typeText("new task"));
        closeSoftKeyboard();
        onView(withId(R.id.radioButton)).perform(click());
        onView(withId(R.id.button6)).perform(click());
    }

    /**
     Author: Triet Nguyen
     deleteTaskTest
     Purpose: test delete task.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void deleteTaskTest() {
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
        onView(withId(R.id.button8)).perform(click());
    }

    /**
     Author: Triet Nguyen
     completeTaskTest
     Purpose: test complete task button.
     Parameters: none.
     Returns: none.
     */
    @Test
    public void completeTaskTest() {
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
        onView(withId(R.id.button4)).perform(click());
        Espresso.pressBack();
    }



}
