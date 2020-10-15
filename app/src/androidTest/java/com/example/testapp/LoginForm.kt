package com.example.testapp

import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice


class LoginForm(device: UiDevice): BaseScreen(device) {

    private val loginButton = By.res("$id/btnLogin")
    private val okButton = By.res("$id/positive")
    private val loginField = By.res("$id/etLogin")
    private val passwordField = By.res("$id/etPassword")
    private val message = By.res("$id/message")

    fun enterLogin(text: String): LoginForm {
        find(loginField).text = text
        return this
    }

    fun enterPassword(text: String): LoginForm {
        find(passwordField).text = text
        return this
    }

    fun clickLogin(): LoginForm {
        click(loginButton)
        return this
    }

    fun clickOk(): LoginForm {
        click(okButton)
        return this
    }

    fun getMessage(): String {
        return find(message).text
    }
}
