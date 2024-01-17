package org.example.pages.util_page.actions

import com.microsoft.playwright.Page
import io.qameta.allure.Allure
import org.example.core.Action
import org.example.data.TestState
import org.example.pages.util_page.UtilPageAction


class NavigateAction(
    private val data: UtilPageAction.Navigate,
) : Action {

    override fun runAction(testState: TestState?, page: Page) {
        Allure.step() {
            it.name(data.javaClass.simpleName)
            page.navigate(data.path)
        }
    }
}
