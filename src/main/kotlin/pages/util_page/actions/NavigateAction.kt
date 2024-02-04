package org.example.pages.util_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import org.example.core.Action
import org.example.core.PageEvent
import org.example.core.allure.createAllureStep
import org.example.data.TestState
import org.example.pages.login_page.actions.LoginAction
import org.example.pages.util_page.UtilPageEvent


class NavigateAction(
    data: UtilPageEvent.Navigate,
    testState: TestState,
    page: Page
) : Action(data, testState, page) {

    override fun runAction(data: PageEvent, testState: TestState, page: Page) {
        data as UtilPageEvent.Navigate
        page.createAllureStep("Переход по ссылке"){
            navigate(data.path)
        }
    }
}

