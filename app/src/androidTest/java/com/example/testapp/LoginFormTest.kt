package com.example.testapp

import androidx.test.filters.SdkSuppress
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
@SdkSuppress(minSdkVersion = 18)
class LoginFormTest: TestHelper() {

    @Test
    @Parameters(value = [
        ",,Необходимо ввести логин и пароль",
        "autotest,,Необходимо ввести пароль",
        "autotest,1,Логин или пароль введен неверно",
        "autotest,autotest,Успешный вход в приложение"
    ])
    fun checkLoginForm(login: String, password: String, expected: String) {
        val result = LoginForm(device)
                .enterLogin(login)
                .enterPassword(password)
                .clickLogin()
                .getMessage()
        assertEquals(expected, result)
    }

}