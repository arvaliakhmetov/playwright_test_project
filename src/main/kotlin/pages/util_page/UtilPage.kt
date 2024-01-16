package org.example.pages.util_page

import com.microsoft.playwright.Page
import org.example.core.Action
import org.example.core.PageRoute
import org.example.data.TestState
import org.example.pages.util_page.actions.NavigateAction


class UtilPage(
    val action: UtilPageAction
): PageRoute {

    override fun getAction(page: Page, state: TestState?) {
        val executableAction: Action = when (action) {
            is UtilPageAction.Navigate -> NavigateAction(action)
        }
        executableAction.runAction(state,page)
    }
}













