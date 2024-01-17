package org.example.pages.login_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import org.example.core.Action
import org.example.core.XpathUtil.configuredPath
import org.example.data.TestState
import org.example.pages.login_page.configs.LoginPageXPaths
import org.example.utils.ScreenShotUtil
import pages.login_page.LoginPageAction


class LoginAction(
    private val data: LoginPageAction.Login,
) : Action {

    override fun runAction(testState: TestState?, page: Page) {
        Allure.step() {
            it.name(data.javaClass.simpleName)
            page.fill(
                configuredPath(LoginPageXPaths.INPUT, "Имя пользователя"),
                data.user.login
            )
            page.fill(
                configuredPath(LoginPageXPaths.INPUT, "Пароль"),
                data.user.password
            )
            page.click(
                configuredPath(LoginPageXPaths.BUTTON, "Войти")
            )
            ScreenShotUtil.saveScreenShot("dummy_shot", page)
            Allure.addAttachment("props", data.user.name)
        }
    }
}

