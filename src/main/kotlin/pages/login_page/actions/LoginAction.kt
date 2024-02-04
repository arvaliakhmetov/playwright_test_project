package org.example.pages.login_page.actions

import com.microsoft.playwright.Page
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.core.Action
import org.example.core.Action.XpathUtil.configuredPath
import org.example.core.PageEvent
import org.example.core.allure.addAllureAttachment
import org.example.core.allure.createAllureStep
import org.example.data.TestState
import org.example.pages.login_page.configs.LoginPageXPaths
import pages.login_page.LoginPageEvent


class LoginAction(
    data: LoginPageEvent.Login,
    testState: TestState,
    page: Page
) : Action(data, testState, page) {

    override fun runAction(data: PageEvent, testState: TestState, page: Page) {
        val json = Json {prettyPrint = true}
        data as LoginPageEvent.Login
        page.createAllureStep("Логин") {
            fill(
                configuredPath(LoginPageXPaths.INPUT, "Имя пользователя"),
                data.user.login
            )
            fill(
                configuredPath(LoginPageXPaths.INPUT, "Пароль"),
                data.user.password
            )
            click(
                configuredPath(LoginPageXPaths.BUTTON, "Войти")
            )
            addAllureAttachment("props", json.encodeToString(data.user).byteInputStream(Charsets.UTF_8))
        }
    }
}

