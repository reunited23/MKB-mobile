package com.example.testapp

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject2

abstract class BaseScreen(private val device: UiDevice) {
    val id = "com.noxx.testapplication:id"
    fun find(by: BySelector): UiObject2 = device.findObject(by)
    fun click(by: BySelector) = find(by).click()
}