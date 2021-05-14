package br.vini.flightticket

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.core.app.ApplicationProvider
import com.facebook.testing.screenshot.Screenshot
import com.karumi.shot.ScreenshotTest
import org.junit.After
import org.junit.Test

class MainActivityTest : BaseTest(), ScreenshotTest {
    lateinit var scenario: ActivityScenario<MainActivity>

    @After
    fun cleanup() {
        scenario.close()
    }

    @Test
    fun myTest() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
        scenario = launch(intent)
        scenario.onActivity {
            takeScreenshotActivity(it, this.javaClass.name, "myTest")
        }
    }

    fun takeScreenshotActivity(activity: Activity, nameClass: String, testName: String) {
        val view = activity.findViewById<View>(android.R.id.content)
        val name = "${nameClass}.${testName}"
        try {
            Screenshot
                .snap(view)
                .setIncludeAccessibilityInfo(false)
                .setName(name)
                .record()
        } catch (t: Throwable) {
            Log.e("Shot", "Exception captured while taking screenshot for snapshot with name $name", t)
        }
    }


    companion object {
        private const val CLASSNAME = "MainActivityTest"
    }
}