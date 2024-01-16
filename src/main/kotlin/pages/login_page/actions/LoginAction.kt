package org.example.pages.login_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import io.qameta.allure.Step
import org.example.core.Action
import org.example.core.XpathUtil.configuredPath
import org.example.data.TestState
import org.example.pages.login_page.configs.LoginPageXPaths
import org.example.utils.ScreenShotUtil
import pages.login_page.LoginPageAction


class LoginAction(
    private val loginData: LoginPageAction.Login,
) : Action {

    @Step("Логин")
    override fun runAction(testState: TestState?, page: Page) {
        page.fill(
            configuredPath(LoginPageXPaths.INPUT,"Имя пользователя"),
            loginData.user.login
        )
        page.fill(
            configuredPath(LoginPageXPaths.INPUT,"Пароль"),
            loginData.user.password
        )
        page.click(
            configuredPath(LoginPageXPaths.BUTTON,"Войти")
        )
        page.waitForConsoleMessage({})
        ScreenShotUtil.saveScreenShot("dummy_shot",page)
        Allure.addAttachment("props",loginData.user.name)
    }

}

