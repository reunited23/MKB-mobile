package com.example.testapp

import android.content.Context
import android.content.Intent
import androidx.test.InstrumentationRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SdkSuppress
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.*
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.runner.RunWith


private const val APPLICATION_PACKAGE_NAME = "com.noxx.testapplication"
private const val LAUNCH_TIMEOUT = 5000L

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
open class TestHelper {

    lateinit var device: UiDevice

    @Before
    fun startApplication() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()

        val launcherPackage: String = device.launcherPackageName
        assertThat(launcherPackage, notNullValue())
        device.wait(
                Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT
        )

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(
                APPLICATION_PACKAGE_NAME)?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        context.startActivity(intent)

        device.wait(
                Until.hasObject(By.pkg(APPLICATION_PACKAGE_NAME).depth(0)),
                LAUNCH_TIMEOUT
        )
    }
}