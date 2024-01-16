package org.example.pages.util_page.actions

import com.microsoft.playwright.Page
import com.microsoft.playwright.options.LoadState
import io.qameta.allure.Step
import org.example.core.Action
import org.example.data.TestState
import org.example.pages.util_page.UtilPageAction


class NavigateAction(
    private val navigateData: UtilPageAction.Navigate,
) : Action {

    @Step("Переход по ссылке")
    override fun runAction(testState: TestState?, page: Page) {
        page.navigate(navigateData.path)
        page.waitForLoadState(LoadState.NETWORKIDLE)
    }

}

